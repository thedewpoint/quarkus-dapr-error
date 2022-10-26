package com.catalogsync.adapters

import com.catalogsync.ports.EventBusPort
import io.dapr.client.DaprClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class DaprEventBus constructor(@Inject val daprClient: DaprClient): EventBusPort {
    val PUB_SUB_NAME = "redis_pub_sub"
    override fun <T> sendMessage(payload: T, topic: String) {
        daprClient.publishEvent(
            PUB_SUB_NAME,
            topic,
            payload
        ).block()
    }
}