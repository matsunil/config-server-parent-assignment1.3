package com.thoughtmechanix.assets.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtmechanix.assets.config.ServiceConfig;
import com.thoughtmechanix.assets.exception.ResourceNotFoundException;
import com.thoughtmechanix.assets.model.Asset;
import com.thoughtmechanix.assets.repository.AssetRepository;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	ServiceConfig config;

	public List<Asset> getAssetsByOrg(String organizationId) {
		return assetRepository.findByOrganizationId(organizationId);
	}

	public Asset getAsset(String organizationId, String assetId) throws ResourceNotFoundException {
		Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId, assetId);
		if (asset != null) {
			return asset.withComment(config.getExampleProperty());
		}

		throw new ResourceNotFoundException("No asset found with organizationId="+organizationId+" and assetId="+assetId);
	}

	public Asset saveAsset(String organizationId, Asset asset) {
		asset.withId( UUID.randomUUID().toString());
		asset.setOrganizationId(organizationId);

		return assetRepository.save(asset);
	}

	public Asset updateAsset(String organizationId, String assetId, Asset assetRequest) throws ResourceNotFoundException {
		Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId, assetId);
		if (asset != null) {
			asset.setAssetName(assetRequest.getAssetName());
			asset.setAssetType(assetRequest.getAssetType());
			asset.setComment(assetRequest.getComment());

			return assetRepository.save(asset);
		}

		throw new ResourceNotFoundException("No asset found with organizationId="+organizationId+" and assetId="+assetId);
	}

	public void deleteAsset(String organizationId, String assetId) throws ResourceNotFoundException {
		Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId, assetId);
		if (asset != null) {
			assetRepository.delete( asset.getAssetId());
		} else {
			throw new ResourceNotFoundException("No asset found with organizationId="+organizationId+" and assetId="+assetId);
		}
	}

}
