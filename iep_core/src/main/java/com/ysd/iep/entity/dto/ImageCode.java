package com.ysd.iep.entity.dto;

import lombok.Data;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class ImageCode extends ValidateCode {
    private static final long serialVersionUID = 6149699556998546213L;

    /**
     * 图片
     */
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public ImageCode() {
    }


}
