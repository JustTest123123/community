package life.majiang.community.community.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//页面展示类
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNextPage;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalpage;
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        pages.clear();
        if(page < 1){
            page = 1;
        }
        if(totalCount % size == 0){
            totalpage = totalCount / size;
        }else {
            totalpage = totalCount / size + 1;
        }
        if(page > totalpage){
            page = totalpage;
        }
        this.page = page;
//      分页的是尽量往前补齐,后面尽量补齐三
        int tem = this.page;
        int index = 3;
        while (tem > 1 && index >= 1){
            pages.add(0,tem - 1);
            tem--;
            index --;
        }
        pages.add(page);
        tem = 1;
        while (tem < 4 && tem + page <= totalpage){
            pages.add(tem + page);
            tem++;
        }
        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }
        if(page == totalpage){
            showNextPage = false;
        }else {
            showNextPage = true;
        }
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }
        if(pages.contains(totalpage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
        System.out.println(pages);
    }
}
