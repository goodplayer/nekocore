package net.moetang.nekocore.storage;

public interface StorageBase {
	public <T> T store(Class<? extends AccessStore> way);
	public <T> T retrieve(Class<? extends AccessRetrieve> way);
}
