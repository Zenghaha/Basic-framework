package com.ud.basic.system.core.storage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ud.basic.system.core.storage.Storage.Type;
import com.ud.basic.common.util.IdGenUtil;
import com.ud.basic.common.util.SpringContextUtil;


/**
 * 文件存储组件
 */
@Component
public class Storager {

    @Value("${storage.type:local}")
    private Type type;

    /**
     * 根据配置文件获取对应的文件存储策略
     * 
     * @return 文件存储策略
     */
    public Storage getStorage() {
        Map<String, Storage> beans = SpringContextUtil.getBeansOfType(Storage.class);
        for (Storage uploader : beans.values()) {
            if (uploader.getType() == type) {
                return uploader;
            }
        }

        throw new RuntimeException("不支持的存储类型");
    }

    /**
     * 根据原图片key，重新生成key
     * 
     * @param key 原图片key
     * @return 重新生成key
     */
    public String buildKey(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        final SimpleDateFormat sdfFolder = new SimpleDateFormat("yyyyMMdd");
        String folder = sdfFolder.format(new Date());
        String fileSuffix = StringUtils.lowerCase(key.substring(key.lastIndexOf(".")));
        String fileNameNew = folder + "/" + IdGenUtil.get32UUID() + fileSuffix;
        return fileNameNew;
    }
}
