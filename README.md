Cassandra Migration (PRE-ALPHA)
========

A migration tool for Apache Cassandra with CQL based on [Axel Fontaine's Flyway project](https://github.com/flyway/flyway).

## Why not create an extension to an existing popular database migration project (i.e. Flyway)?
Popular database migration tools, such as Flyway and Liquibase are tailored for relational databases with JDBC. This project exists because...
* Cassandra is not a relational database
* Cassandra does not have transactions
* Cassandra currently does not have production-ready JDBC implementation
* It does not make sense to attempt implementing parity with relational database functions like global sequence IDs for Cassandra
* Cassandra's keyspace should be managed outside the migration tool for sysadmins to configure replication factor, etc
* CQL != SQL
* The tool should be tailored to Cassandra, especially from the perspective of its distributed architecture
* I already use Flyway and I do not want to maintain my own version of Flyway with Cassandra hacks

## Requirements
* Apache Cassandra (Tested with version 2.1.5)
* CQL schema
* JDK (tested on JDK 7+)
* Pre-populated keyspace

## Interface
* Java API
* Command line

## Supported Migration Script Types
* .cql files
* Java classes

## Java API
Example:
```
CassandraMigration cm = new CassandraMigration();
Keyspace ks = new Keyspace();
ks.setName("mykeyspace");
cm.setKeyspace(ks);
cm.migrate();
```

## Command line
```
Main class: 'com.contrastsecurity.cassandra.migration.CommandLine'
VM options: '-Dcassandra.migration.keyspace.name=mykeyspace'
Arguments: 'migrate -X'
```

Logging level can be set by passing the following arguments:
* INFO: This is the default
* DEBUG: '-X'
* WARNING: '-q'

## Options
Options can be set via either API or VM option.

Cluster
* cassandra.migration.cluster.contactpoints: Comma separated values of node IP addresses (default=localhost)
* cassandra.migration.cluster.port: CQL native transport port (default=9042)
* cassandra.migration.cluster.username: Username for password authenticator (optional)
* cassandra.migration.cluster.password: Password for password authenticator (optional)

Keyspace
* cassandra.migration.keyspace.name: Name of Cassandra keyspace (required)

Schema version table
* cassandra.migration.version.table: Migration version table name(default=migration_version)

Migration scripts
* cassandra.migration.scripts.locations: Locations of the migration scripts in CSV format. Scripts are scanned in the specified folder recursively.

## Limitations
Does not implement node coordination in cluster yet.