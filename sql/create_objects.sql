/*cpu index*/
CREATE TABLE IF NOT EXISTS  `monitor_cpu_used` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_steal` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_idle` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_user` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_nice` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_aidle` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_system` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_wio` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_cpu_speed` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

/*memory index*/
CREATE TABLE IF NOT EXISTS  `monitor_mem_total` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_cached` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_swap_total` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_swap_free` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_shared` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_free` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_mem_buffers` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

/*disk index*/
CREATE TABLE IF NOT EXISTS  `monitor_disk_total` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_disk_free` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_disk_part_max_used` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

/*load index*/
CREATE TABLE IF NOT EXISTS  `monitor_load_one` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_load_five` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_load_fifteen` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

/*network*/
CREATE TABLE IF NOT EXISTS  `monitor_network_pkts_in` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_network_pkts_out` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_network_bytes_in` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_network_bytes_out` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

/*process*/
CREATE TABLE IF NOT EXISTS  `monitor_proc_total` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  `monitor_proc_run` (
  `ip` VARCHAR(128) NULL,
  `value` FLOAT NULL,
  `unit` VARCHAR(128) NULL,
  `time` DATETIME NULL)
ENGINE = InnoDB;