package com.opera.link.apilib.items;

import java.util.ArrayList;

public interface FolderInterface <T extends FolderEntry<?> > {
	
	boolean isTrash();
	
	ArrayList<T> getChildren();
	
	FolderContext<T> getFolderContext();
	
	String getId();
}
