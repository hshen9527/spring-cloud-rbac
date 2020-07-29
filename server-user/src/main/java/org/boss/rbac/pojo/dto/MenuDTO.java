package org.boss.rbac.pojo.dto;

import org.boss.rbac.pojo.vo.MenuAddVO;

import java.util.Arrays;
import java.util.List;

public class MenuDTO {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public MenuDTO(MenuAddVO menuAddVO){
        this.list = Arrays.asList(menuAddVO.getMenus().split(","));
    }
}
