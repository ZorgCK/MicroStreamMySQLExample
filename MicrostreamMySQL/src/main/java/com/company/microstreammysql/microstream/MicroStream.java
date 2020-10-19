
package com.company.microstreammysql.microstream;

import com.company.microstreammysql.ui.DataSourceUtils;

import one.microstream.afs.sql.SqlFileSystem;
import one.microstream.afs.sql.SqlProviderMySql;
import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;
import one.microstream.storage.types.Storage;
import one.microstream.storage.types.StorageConfiguration;


public final class MicroStream
{
	private final static DataRoot               root = new DataRoot();
	private final static EmbeddedStorageManager storageManager;
	static
	{
		
		final SqlFileSystem sqlFileSystem =
			SqlFileSystem.New(SqlProviderMySql.New(DataSourceUtils.getMySQLDataSource()));
		
		final StorageConfiguration storageConfiguration = Storage.ConfigurationBuilder()
			.setStorageFileProvider(Storage.FileProvider(
				sqlFileSystem.ensureDirectoryPath("storage-dir")))
			.setBackupSetup(Storage.BackupSetup(
				sqlFileSystem.ensureDirectoryPath("backup-bucket", "mydir", "subdir")))
			.createConfiguration();
		
		storageManager = EmbeddedStorage.Foundation(storageConfiguration).start();
		
	}

	public static DataRoot root()
	{
		return MicroStream.root;
	}

	public static EmbeddedStorageManager storageManager()
	{
		return MicroStream.storageManager;
	}

	private MicroStream()
	{
	}
}
