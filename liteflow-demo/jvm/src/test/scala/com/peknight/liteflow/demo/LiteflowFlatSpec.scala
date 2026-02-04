package com.peknight.liteflow.demo

import com.yomahub.liteflow.core.FlowExecutorHolder
import com.yomahub.liteflow.property.LiteflowConfig
import com.yomahub.liteflow.slot.DefaultContext
import org.scalatest.flatspec.AnyFlatSpec

class LiteflowFlatSpec extends AnyFlatSpec:
  "Liteflow" should "succeed" in {
    val config = new LiteflowConfig;
    config.setRuleSource("config/flow.xml")
    val flowExecutor = FlowExecutorHolder.loadInstance(config)
    val response = flowExecutor.execute2Resp("chain1", "arg", classOf[DefaultContext])
    println(response)
  }
end LiteflowFlatSpec
