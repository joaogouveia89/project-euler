import base.Solution

//months
private const val JANUARY = 1
private const val FEBRUARY = 2
private const val APRIL = 4
private const val JUNE = 6
private const val SEPTEMBER = 9
private const val NOVEMBER = 11
private const val DECEMBER = 12

// days of week
private const val MONDAY = 1
private const val SUNDAY = 7

class CountingSundays : Solution {

    override val rightSolution = 171L

    private val finalDate = SimpleDate(31, DECEMBER, 2000, MONDAY /* doesnt matter here, to be right */)

    override fun solve(): Long {
        var sundaysCount = 0L

        // on problem description: 1 Jan 1900 was a Monday.
        val currentDate = SimpleDate(1, JANUARY, 1900, MONDAY)

        while (currentDate != finalDate) {
            if (currentDate.dayOfWeek == SUNDAY &&
                currentDate.day == 1 &&
                currentDate.year > 1900
            ) {
                sundaysCount++
            }
            currentDate.incrementOneDay()
        }

        return sundaysCount
    }

    class SimpleDate(
        private var _day: Int,
        private var _month: Int,
        _year: Int,
        private var _dayOfWeek: Int
    ) {

        private var _year: Int = _year
            set(value) {
                // A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
                isLeapYear = (value % 4 == 0 && value % 100 != 0) || value % 400 == 0
                field = value
            }

        // Thirty days has September, April, June and November
        private val thirtyDaysMonths = listOf(
            SEPTEMBER,
            APRIL,
            JUNE,
            NOVEMBER
        )

        private var isLeapYear = false

        val day: Int
            get() = _day
        val month: Int
            get() = _month
        val year: Int
            get() = _year
        val dayOfWeek: Int
            get() = _dayOfWeek

        fun incrementOneDay() {
            if (thirtyDaysMonths.contains(month)) {
                if (day == 30) {
                    _day = 1
                    _month++
                } else {
                    _day++
                }
            } else if (month == FEBRUARY) {
                val maxDay = if (isLeapYear) 29 else 28
                if (day == maxDay) {
                    _day = 1
                    _month++
                } else {
                    _day++
                }
            } else {
                if (day == 31) {
                    _day = 1
					_year = if (month == DECEMBER) _year + 1 else _year
                    _month = if (month == DECEMBER) JANUARY else _month + 1
                } else {
                    _day++
                }
            }

            _dayOfWeek = if (dayOfWeek == SUNDAY) MONDAY else _dayOfWeek + 1
        }

        override operator fun equals(other: Any?): Boolean =
            (other is SimpleDate) &&
                    day == other.day &&
                    month == other.month &&
                    year == other.year


        override fun hashCode(): Int {
            var result = _day
            result = 31 * result + _month
            result = 31 * result + _dayOfWeek
            result = 31 * result + _year
            result = 31 * result + thirtyDaysMonths.hashCode()
            result = 31 * result + isLeapYear.hashCode()
            return result
        }
    }
}