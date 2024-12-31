package com.datapac.troubleshootingTool.AssetTag;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AssetTagService {
    
    private final AssetTagRepository assetTagRepository;

    public AssetTagService(AssetTagRepository assetTagRepository) {
        this.assetTagRepository = assetTagRepository;
    }

    public AssetTag createAssetTag(AssetTag assetTag) {
        return assetTagRepository.save(assetTag);
    }

    public AssetTag findAssetTagById(Long id) {
        return assetTagRepository.findById(id).get();
    }

    public List<AssetTag> getAllAssetTags() {
        return assetTagRepository.findAll();
    }

    public AssetTag updateAssetTag(AssetTag assetTag, Long id) {
        AssetTag foundAssetTag = assetTagRepository.findById(id).get();

        foundAssetTag.setTagNumber(assetTag.getTagNumber());

        return assetTagRepository.save(foundAssetTag);
    }

    public String deleteAssetTag(Long id) {
        assetTagRepository.deleteById(id);
        return "Asset Tag deleted.";
    }
}
