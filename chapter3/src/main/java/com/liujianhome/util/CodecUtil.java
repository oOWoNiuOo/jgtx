package com.liujianhome.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/6/27.
 */
public final class CodecUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将 URL 编码
     *
     * @param source
     * @return
     */
    public static String encodeURL(String source) {
        String encodeValue = null;
        try {
            encodeValue = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("编码失败!", e);
            throw new RuntimeException(e);
        }
        return encodeValue;
    }

    /**
     * 将 URL 解码
     *
     * @param source
     * @return
     */
    public static String decodeURL(String source) {
        String decoderValue = null;
        try {
            decoderValue = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("解码失败!", e);
            throw new RuntimeException(e);
        }
        return decoderValue;
    }

}
