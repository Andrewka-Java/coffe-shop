package com.coffee.shop.config

import com.coffee.shop.model.Country
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.stereotype.Component

@WritingConverter
object CountryWritingConverter : Converter<Country, String> {
    override fun convert(source: Country): String =
        source.label
}

@ReadingConverter
object CountryReadingConverter : Converter<String, Country> {
    override fun convert(source: String): Country =
        Country.getCountry(source)
}

@Component
class CountryConvertor : AbstractJdbcConfiguration() {
    override fun userConverters(): List<*> =
        listOf(CountryWritingConverter, CountryReadingConverter)
}
