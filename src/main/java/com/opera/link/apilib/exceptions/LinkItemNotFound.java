package com.opera.link.apilib.exceptions;




public class LinkItemNotFound extends LibOperaLinkException {

	public LinkItemNotFound() {
		super("Requested item with id given does not exist on the server");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
