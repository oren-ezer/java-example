def withRetry(iterations, sleepTime, Closure closure) {
    for (i = 0; true; i++) {
        try {
            println "Try number ${i}"
            closure()
            break
        } catch (Exception e) {
            if (i < iterations) {
                sleep sleepTime
                println "Retrying..."
            } else {
                error("Exceeded number of retries. Exception was: ${e.message}")
            }
        }
    }
}

def restGetJson(url, credentialId) {
    res = httpRequest url: url, contentType: "APPLICATION_JSON", authentication: credentialId
    res.getStatus()
    res.getContent()
}

return this