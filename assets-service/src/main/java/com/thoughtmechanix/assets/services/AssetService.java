package com.thoughtmechanix.assets.services;

import com.thoughtmechanix.assets.config.ServiceConfig;
import com.thoughtmechanix.assets.model.Asset;
import com.thoughtmechanix.assets.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    ServiceConfig config;

    public Asset getAsset(String organizationId,String assetId) {
        Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId, assetId);
        return asset.withComment(config.getExampleProperty());
    }

    public List<Asset> getAssetsByOrg(String organizationId){
        return assetRepository.findByOrganizationId( organizationId );
    }

    public void saveAsset(Asset asset){
        asset.withId( UUID.randomUUID().toString());

        assetRepository.save(asset);

    }

    public void updateAsset(Asset asset){
      assetRepository.save(asset);
    }

    public void deleteAsset(Asset asset){
        assetRepository.delete( asset.getAssetId());
    }

}
