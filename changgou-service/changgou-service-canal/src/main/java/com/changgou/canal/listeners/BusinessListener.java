package com.changgou.canal.listeners;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据变化的监听器
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/20 14:09
 * @since 1.0
 */
@CanalEventListener
@Slf4j
public class BusinessListener  {

  @ListenPoint(schema = {"changgou_business"},table = {"tb_ad"})
  public void tableEvent(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
    log.info("-------------start----------------");
    log.info("数据发生了变化：{}",eventType);
    log.info("发送变化的数:{}",rowData);
    log.info("变化前的数据：{}",rowData.getBeforeColumnsList());
    log.info("变化后的数据：{}",rowData.getAfterColumnsList());
    log.info("-------------end---------------");
  }
}

