package leakcanary

object LeakCanary {

  data class Config(

    val onHeapAnalyzedListener: Any? = null

  )
  @JvmStatic @Volatile
  var config: Config = Config()

}