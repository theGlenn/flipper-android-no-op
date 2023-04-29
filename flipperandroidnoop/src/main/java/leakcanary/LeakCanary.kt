package leakcanary

object LeakCanary {

  data class Config(

    @Deprecated(message = "Add to LeakCanary.config.eventListeners instead")
    val onHeapAnalyzedListener: Any? = null,
    val eventListeners: List<EventListener> = listOf()

  )
  @JvmStatic @Volatile
  var config: Config = Config()

}
