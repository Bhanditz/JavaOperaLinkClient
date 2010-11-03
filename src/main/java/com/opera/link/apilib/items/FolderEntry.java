package com.opera.link.apilib.items;


public abstract class FolderEntry <T extends FolderEntry<?> > extends Element {
	
	public boolean isFolder() {
		return false;
	}

}
