CREATE TABLE IF NOT EXISTS `monitor_alert` (
  `id` VARCHAR(128) NOT NULL,
  `time` DATETIME NULL,
  `target_type` INT NULL,
  `target_id` VARCHAR(128) NULL,
  `level` INT NULL,
  `description` VARCHAR(128) NULL,
  `status` INT NULL,
  `properties` TEXT NULL,
  `source` VARCHAR(128) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `monitor_alert_config_metric` (
  `id` VARCHAR(128) NOT NULL,
  `target_type` INT NULL,
  `target_id` VARCHAR(128) NULL,
  `keep_time` INT NULL,
  `recover_time` INT NULL,
  `threshold_value` FLOAT NULL,
  `threshold_symbol` VARCHAR(64) NULL,
  `level` INT NULL,
  `metric` VARCHAR(128) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

