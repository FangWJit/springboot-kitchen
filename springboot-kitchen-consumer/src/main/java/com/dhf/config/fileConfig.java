package com.dhf.config;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class fileConfig extends CommonsMultipartResolver {

    @Override
    protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {


        return super.newFileUpload(fileItemFactory);
    }
}
