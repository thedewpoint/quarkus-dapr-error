package com.catalogsync.adapters

import io.dapr.client.DaprClient
import io.dapr.client.DaprClientBuilder
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

@ApplicationScoped
class DaprProducer {
    @Produces
    fun getDaprClient(): DaprClient = DaprClientBuilder().build()

}

