// Nasty hack as there is no kotlin.system yet
@JsFun("() => (new Date().getSeconds()*1000) + new Date().getMilliseconds()")
external fun getTime() : Int

fun time():String {
   return "Miliseconds " + getTime()
}

// Stolen from https://proandroiddev.com/measuring-execution-times-in-kotlin-460a0285e5ea
inline fun <T> measureTimeMillis(loggingFunction: (Int) -> Unit,
                                 function: () -> T): T {

    val startTime = getTime()
    val result: T = function.invoke()
    loggingFunction.invoke(getTime() - startTime)

    return result
}