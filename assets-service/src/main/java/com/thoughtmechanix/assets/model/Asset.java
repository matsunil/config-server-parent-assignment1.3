package com.thoughtmechanix.assets.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset{
  @Id
  @Column(name = "asset_id", nullable = false)
  private String assetId;

  @Column(name = "organization_id", nullable = false)
  private String organizationId;

  @Column(name = "asset_name", nullable = false)
  private String assetName;

  @Column(name = "asset_type", nullable = false)
  private String assetType;

  @Column(name="comment")
  private String comment;


  public String getComment() {
	    return comment;
	  }

	  public void setComment(String comment) {
	    this.comment = comment;
	  }

  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public String getAssetName() {
    return assetName;
  }

  public void setAssetName(String assetName) {
    this.assetName = assetName;
  }

  public String getAssetType() {
    return assetType;
  }

  public void setAssetType(String assetType) {
    this.assetType = assetType;
  }

  public Asset withId(String id){
    this.setAssetId(id);
    return this;
  }

  public Asset withOrganizationId(String organizationId){
    this.setOrganizationId(organizationId);
    return this;
  }

  public Asset withAssetName(String assetName){
    this.setAssetName(assetName);
    return this;
  }

  public Asset withAssetType(String assetType){
    this.setAssetType(assetType);
    return this;
  }

  public Asset withComment(String comment){
	    this.setComment(comment);
	    return this;
	  }

}
