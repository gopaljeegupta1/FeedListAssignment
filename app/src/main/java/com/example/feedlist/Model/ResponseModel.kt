package com.example.feedlist.Model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseModel {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("rows")
    @Expose
    var rows: List<Row>? = null

    /**
     * No args constructor for use in serialization
     */
    constructor() {}

    /**
     * @param title
     * @param rows
     */
    constructor(title: String, rows: List<Row>) : super() {
        this.title = title
        this.rows = rows
    }


    inner class Row {

        @SerializedName("title")
        @Expose
        var title: String? = null
        @SerializedName("description")
        @Expose
        var description: String? = null
        @SerializedName("imageHref")
        @Expose
        var imageHref: String? = null

        /**
         * No args constructor for use in serialization
         */
        constructor() {}

        /**
         * @param imageHref
         * @param description
         * @param title
         */
        constructor(title: String, description: String, imageHref: String) : super() {
            this.title = title
            this.description = description
            this.imageHref = imageHref
        }

    }

}
