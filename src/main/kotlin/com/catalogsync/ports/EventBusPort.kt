package com.catalogsync.ports

interface EventBusPort {
    fun <T>sendMessage(payload: T, topic: String);
}