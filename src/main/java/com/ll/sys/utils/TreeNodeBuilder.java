package com.ll.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 10:50
 */

public class TreeNodeBuilder {
    /**
     * 将简单的集合转化为层级关系集合
     * @param nodes
     * @param topid
     * @return
     * */
    /**
     * 把简单的集合转成有层级关系的集合
     * @param nodes
     * @param topid
     * @return
     */
    public static List<TreeNode> builder(List<TreeNode> nodes, Integer topid) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode n1:nodes) {
            if(n1.getPid()==topid){
                treeNodes.add(n1);
            }
            for (TreeNode n2:nodes) {
                if(n2.getPid()==n1.getId()){
                    n1.getChildren().add(n2);
                }
            }
        }
        return treeNodes;
    }


}
