package com.ysd.iep.entity.courcePaging;

import com.ysd.iep.entity.dto.CommentDTO;
import com.ysd.iep.entity.dto.CourceDTO;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.StudentFeign;
import com.ysd.iep.feign.TeacherFeign;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class OrderCourcePaging implements CourceState {
    private String order;
    @Autowired(required = false)
    private StudentFeign studentFeign;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;


    @Deprecated
    @Override
    public PagingResult<CourceDTO> pagingCource(Integer page, Integer rows) {
        //FIXME 方法有问题 需要沟通
        Page<CommentDTO> commentDTOS = studentFeign.queryOrder(page, rows, order);
        List<Integer> cids=commentDTOS.getContent().stream().map(CommentDTO::getCid).collect(Collectors.toList());
        if(cids.size()<rows){
            int result=rows-cids.size();
        }
        String cidsStr=StringUtils.join(cids,",");
        List<CourceDTO> courses = teacherFeign.findCourseById(cidsStr);
        return new PagingResult()
                .setTotal(commentDTOS.getTotalElements())
                .setRows(courses);
    }
}
