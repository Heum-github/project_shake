package com.smhrd.shake.converter;

import java.io.IOException;

public interface ImageConverter<F, S>{
	public S convert(F f) throws IOException;
}
