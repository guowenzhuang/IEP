package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.PostDTO;
import com.ysd.iep.entity.dto.ReplyDTO;
import com.ysd.iep.entity.vo.PagingResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-BBS")
public interface BbsFeign {
    /**
     * 根据用户id分页查询帖子
     * @param userId
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/post/queryPostByUserId")
    PagingResult<PostDTO> queryPostByUserId(@RequestParam("userId") String userId,
                                                    @RequestParam("page") Integer page,
                                                    @RequestParam("rows") Integer rows);

    @RequestMapping(value = "/reply/queryReplyByUserId")
    PagingResult<ReplyDTO> queryReplyByUserId(@RequestParam("userId") String userId,
                                             @RequestParam("page") Integer page,
                                             @RequestParam("rows") Integer rows);
}
