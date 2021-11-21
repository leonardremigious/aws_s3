package com.aws.aws_storage_s3;



import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class AwsS3Controller {

    @GetMapping("/test")
    public String test(){

        AWSCredentials credentials = new BasicAWSCredentials("<secret key>", "<secret>");

        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1).build();

        if (!client.doesBucketExistV2("testbucket")) {
            client.createBucket("testbucket");
        }

        File file = new File("/home/local/ZOHOCORP/leonard-10688/Documents/zoho jsps/dns.py");

        client.putObject("testbucket","test-file_"+file.getName(), file);

        return "";
    }
}
