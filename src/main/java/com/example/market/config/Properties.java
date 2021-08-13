package com.example.market.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "kr.sharenshare.keylitadmin")
public class Properties {

    private String mode;
    private List<String> whiteIpList;

    private String superAdmin;

    private String ncpAccessKey;
    private String ncpSecretKey;

    private List<String> supportImageExtension;
    private String uploadImagePath;
    private long uploadImageSize;

    private String cdnEndPoint;
    private String cdnRegionName;
    private String cdnHost;
    private String cdnPublicBucket;

    private String tempFolderPath;

    private String businessLicensePath;
    private String carModelPath;

    private String ocrSecretKey;
    private String ocrURL;
    private String ocrTemplateId;

}
