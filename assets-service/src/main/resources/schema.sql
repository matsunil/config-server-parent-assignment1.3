DROP TABLE IF EXISTS assets;

CREATE TABLE assets (
  asset_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  organization_id   TEXT NOT NULL,
  asset_type      TEXT NOT NULL,
  asset_name      TEXT NOT NULL,
  comment           VARCHAR(100));


INSERT INTO assets (asset_id,  organization_id, asset_type, asset_name)
VALUES ('f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user','customer-crm-co');
INSERT INTO assets (asset_id,  organization_id, asset_type, asset_name)
VALUES ('t9876f8c-c338-4abc-zf6a-ttt1', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user','suitability-plus');
INSERT INTO assets (asset_id,  organization_id, asset_type, asset_name)
VALUES ('38777179-7094-4200-9d61-edb101c6ea84', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'user','HR-PowerSuite');
INSERT INTO assets (asset_id,  organization_id, asset_type, asset_name)
VALUES ('08dbe05-606e-4dad-9d33-90ef10e334f9', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'core-prod','WildCat Application Gateway');