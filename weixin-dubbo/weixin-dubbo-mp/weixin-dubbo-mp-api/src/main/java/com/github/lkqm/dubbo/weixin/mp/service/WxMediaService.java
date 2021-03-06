package com.github.lkqm.dubbo.weixin.mp.service;

import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.mp.bean.material.*;

import java.io.File;
import java.io.InputStream;

/**
 * 媒体管理
 * // TODO:
 */
public interface WxMediaService {


    WxMediaUploadResult mediaUpload(String mediaType, File file);

    WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream);

    File mediaDownload(String mediaId);

    WxMediaImgUploadResult mediaImgUpload(File file);

    WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material);

    WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news);

    InputStream materialImageOrVoiceDownload(String mediaId);

    WxMpMaterialVideoInfoResult materialVideoInfo(String mediaId);

    WxMpMaterialNews materialNewsInfo(String mediaId);

    boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate);

    boolean materialDelete(String mediaId);

    WxMpMaterialCountResult materialCount();

    WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count);

    WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count);

}
