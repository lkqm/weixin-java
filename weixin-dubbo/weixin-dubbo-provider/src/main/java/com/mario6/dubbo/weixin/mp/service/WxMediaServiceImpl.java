package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.bean.material.*;

import java.io.File;
import java.io.InputStream;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxMediaServiceImpl implements WxMediaService {

    private WxMpMaterialService wxMpMaterialService;

    @Override
    public WxMediaUploadResult mediaUpload(String mediaType, File file) {
        return handle(() -> wxMpMaterialService.mediaUpload(mediaType, file));
    }

    @Override
    public WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream) {
        return handle(() -> wxMpMaterialService.mediaUpload(mediaType, fileType, inputStream));
    }

    @Override
    public File mediaDownload(String mediaId) {
        return handle(() -> wxMpMaterialService.mediaDownload(mediaId));
    }

    @Override
    public WxMediaImgUploadResult mediaImgUpload(File file) {
        return handle(() -> wxMpMaterialService.mediaImgUpload(file));
    }

    @Override
    public WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) {
        return handle(() -> wxMpMaterialService.materialFileUpload(mediaType, material));
    }

    @Override
    public WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) {
        return handle(() -> wxMpMaterialService.materialNewsUpload(news));
    }

    @Override
    public InputStream materialImageOrVoiceDownload(String mediaId) {
        return handle(() -> wxMpMaterialService.materialImageOrVoiceDownload(mediaId));
    }

    @Override
    public WxMpMaterialVideoInfoResult materialVideoInfo(String mediaId) {
        return handle(() -> wxMpMaterialService.materialVideoInfo(mediaId));
    }

    @Override
    public WxMpMaterialNews materialNewsInfo(String mediaId) {
        return handle(() -> wxMpMaterialService.materialNewsInfo(mediaId));
    }

    @Override
    public boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) {
        return handle(() -> wxMpMaterialService.materialNewsUpdate(wxMpMaterialArticleUpdate));
    }

    @Override
    public boolean materialDelete(String mediaId) {
        return handle(() -> wxMpMaterialService.materialDelete(mediaId));
    }

    @Override
    public WxMpMaterialCountResult materialCount() {
        return handle(() -> wxMpMaterialService.materialCount());
    }

    @Override
    public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) {
        return handle(() -> wxMpMaterialService.materialNewsBatchGet(offset, count));
    }

    @Override
    public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) {
        return handle(() -> wxMpMaterialService.materialFileBatchGet(type, offset, count));
    }


}
