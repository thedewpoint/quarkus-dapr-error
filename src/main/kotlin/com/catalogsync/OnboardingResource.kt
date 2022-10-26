package com.catalogsync

import com.catalogsync.domain.OnboardingEvent
import com.catalogsync.ports.EventBusPort
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/onboarding")
class OnboardingResource constructor(@Inject val eventBus: EventBusPort){
    val TOPIC_NAME = "shop.triggers"
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun health() = "healthy"

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun publish(onboardingEvent: OnboardingEvent) = eventBus.sendMessage(onboardingEvent,TOPIC_NAME )
}