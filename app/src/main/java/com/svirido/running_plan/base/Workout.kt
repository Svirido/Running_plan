package com.svirido.running_plan.base

import java.io.Serializable

class Workout(
    var id: Int?,
    var type: String,
    var date: String,
    var dayWeek: String,
    var train: String,
    var description: String,
    var report: String,
): Serializable {


}