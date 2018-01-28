package com.progex.hris.util;

import org.modelmapper.ModelMapper;

public class Util {
	public static <D> D toDto(ModelMapper mapper, Object source, Class<D> destinationType) {
		return  mapper.map(source, destinationType);
	}
}
