package com.example.market.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.util.List;

public class CDNHelper {

    public static CDNHelper getInstance(String endPoint, String regionName, String accessKey, String secretKey) {
        return new CDNHelper(endPoint, regionName, accessKey, secretKey);
    }

    private final AmazonS3 s3;

    private CDNHelper(String endPoint, String regionName, String accessKey, String secretKey) {
        s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }

    public List<Bucket> getBucketList() {
        return s3.listBuckets();
    }

    public Bucket findBucketByBucketName(String bucketName) {
        if (bucketName == null || bucketName.equals("")) return null;
        for (Bucket bucket : getBucketList()) {
            if (bucket.getName().equals(bucketName)) {
                return bucket;
            }
        }

        return null;
    }

    public Bucket createBucket(String bucketName) {
        if (s3.doesBucketExistV2(bucketName)) return findBucketByBucketName(bucketName);
        return s3.createBucket(bucketName);
    }

    public void uploadObject(String bucketName, String path, File file) {
        Bucket bucket = findBucketByBucketName(bucketName);
        if (bucket == null) bucket = createBucket(bucketName);

        String objectName = path + file.getName();

        PutObjectRequest filePutObjectRequest = new PutObjectRequest(bucket.getName(), objectName, file);
        s3.putObject(filePutObjectRequest);

        AccessControlList accessControlList = s3.getObjectAcl(bucket.getName(), objectName);
        accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);

        s3.setObjectAcl(bucket.getName(), objectName, accessControlList);
    }

}
