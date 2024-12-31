package com.datapac.troubleshootingTool.AssetTag;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assetTags")
public class AssetTagController {
    
    private final AssetTagService assetTagService;

    public AssetTagController(AssetTagService assetTagService) {
        this.assetTagService = assetTagService;
    }

    // create
    @PostMapping("/new")
    public AssetTag createAssetTag(@RequestBody AssetTag assetTag) {
        return assetTagService.createAssetTag(assetTag);
    }

    // read all
    @GetMapping("/all")
    public List<AssetTag> findAllAssetTags() {
        return assetTagService.getAllAssetTags();
    }

    // read by id
    @GetMapping("/{id}")
    public AssetTag findAssetTagById(@PathVariable Long id) {
        return assetTagService.findAssetTagById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public AssetTag updateAssetTag(@RequestBody AssetTag assetTag, @PathVariable Long id) {
        return assetTagService.updateAssetTag(assetTag, id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String deleteAssetTag(@PathVariable Long id) {
        return assetTagService.deleteAssetTag(id);
    }
}
