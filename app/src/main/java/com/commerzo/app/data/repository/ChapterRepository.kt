package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.ClassLevel

class ChapterRepository {

    fun getChapters(
        subjectId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<ChapterData> {

        return when (board) {
            Board.MP_BOARD -> getMpBoardChapters(subjectId, classLevel)
            Board.CBSE -> getCbseChapters(subjectId, classLevel)
        }
    }

    // ---------------------------------------------------------
    // MP BOARD
    // ---------------------------------------------------------

    private fun getMpBoardChapters(
        subjectId: String,
        classLevel: ClassLevel
    ): List<ChapterData> {

        return when (classLevel) {

            ClassLevel.CLASS_11 -> getMpBoardClass11Chapters(subjectId)

            ClassLevel.CLASS_12 -> getMpBoardClass12Chapters(subjectId)
        }
    }

    private fun getMpBoardClass11Chapters(
        subjectId: String
    ): List<ChapterData> {

        /*
         * Class 11 MP Board structure currently retained from the
         * existing COMMERZO curriculum until the exact 2026-27
         * MPBSE Class 11 chapter PDF is available.
         *
         * Do not generate questions from unverified chapters.
         */

        return when (subjectId) {

            "accountancy" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction to Accounting",
                    "Theory Base of Accounting",
                    "Recording of Transactions",
                    "Bank Reconciliation Statement",
                    "Trial Balance and Rectification of Errors",
                    "Depreciation, Provisions and Reserves",
                    "Bill of Exchange",
                    "Financial Statements"
                )
            )

            "business_studies" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "Nature and Purpose of Business",
                    "Forms of Business Organisation",
                    "Public, Private and Global Enterprises",
                    "Business Services",
                    "Emerging Modes of Business",
                    "Social Responsibility of Business",
                    "Formation of a Company",
                    "Sources of Business Finance",
                    "Small Business",
                    "Internal Trade",
                    "International Business"
                )
            )

            "economics" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction to Economics",
                    "Theory of Consumer Behaviour",
                    "Theory of Demand",
                    "Theory of Production",
                    "Cost and Revenue",
                    "Perfect Competition",
                    "Statistics for Economics",
                    "Collection of Data",
                    "Organisation of Data",
                    "Presentation of Data",
                    "Statistical Measures"
                )
            )

            "mathematics" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "Sets",
                    "Relations and Functions",
                    "Trigonometric Functions",
                    "Complex Numbers and Quadratic Equations",
                    "Linear Inequalities",
                    "Permutations and Combinations",
                    "Binomial Theorem",
                    "Sequences and Series",
                    "Straight Lines",
                    "Conic Sections",
                    "Introduction to Three Dimensional Geometry",
                    "Limits and Derivatives",
                    "Statistics",
                    "Probability"
                )
            )

            "english" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "Reading Comprehension",
                    "Grammar and Creative Writing",
                    "Hornbill",
                    "Snapshots"
                )
            )

            "hindi" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_11,
                listOf(
                    "आरोह",
                    "वितान",
                    "अभिव्यक्ति और माध्यम"
                )
            )

            else -> emptyList()
        }
    }

    private fun getMpBoardClass12Chapters(
        subjectId: String
    ): List<ChapterData> {

        return when (subjectId) {

            // -------------------------------------------------
            // ACCOUNTANCY - MP BOARD CLASS 12
            // -------------------------------------------------

            "accountancy" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    "Accounting for Partnership: Basic Concepts",
                    "Reconstitution of a Partnership Firm—Admission of a Partner",
                    "Reconstitution of a Partnership Firm—Retirement/Death of a Partner",
                    "Dissolution of Partnership Firm",
                    "Accounting for Share Capital",
                    "Issue and Redemption of Debentures",
                    "Financial Statements of a Company",
                    "Accounting Ratios",
                    "Cash Flow Statement"
                )
            )

            // -------------------------------------------------
            // BUSINESS STUDIES - MP BOARD CLASS 12
            // -------------------------------------------------

            "business_studies" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    "Nature and Significance of Management",
                    "Principles of Management",
                    "Business Environment",
                    "Planning",
                    "Organising",
                    "Staffing",
                    "Directing",
                    "Controlling",
                    "Financial Management",
                    "Financial Market",
                    "Marketing Management",
                    "Consumer Protection"
                )
            )

            // -------------------------------------------------
            // ECONOMICS - MP BOARD CLASS 12
            // -------------------------------------------------

            "economics" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    // Introductory Microeconomics
                    "Introduction",
                    "Theory of Consumer Behaviour",
                    "Production and Costs",
                    "The Theory of the Firm Under Perfect Competition",
                    "Market Equilibrium",

                    // Introductory Macroeconomics
                    "Introduction",
                    "National Income Accounting",
                    "Money and Banking",
                    "Determination of Income and Employment",
                    "Government Budget and The Economy",
                    "Open Economy Macroeconomics",

                    // Indian Economic Development
                    "Indian Economy on the Eve of Independence",
                    "Indian Economy (1950–1990)",
                    "Economic Reforms Since 1991: New Economic Policy",
                    "Human Capital Formation in India",
                    "Rural Development",
                    "Employment",
                    "Environment and Sustainable Development",
                    "Comparative Development Experiences of India and its Neighbours"
                ),
                chapterIds = listOf(
                    "economics_class_12_micro_1",
                    "economics_class_12_micro_2",
                    "economics_class_12_micro_3",
                    "economics_class_12_micro_4",
                    "economics_class_12_micro_5",
                    "economics_class_12_macro_1",
                    "economics_class_12_macro_2",
                    "economics_class_12_macro_3",
                    "economics_class_12_macro_4",
                    "economics_class_12_macro_5",
                    "economics_class_12_macro_6",
                    "economics_class_12_ied_1",
                    "economics_class_12_ied_2",
                    "economics_class_12_ied_3",
                    "economics_class_12_ied_4",
                    "economics_class_12_ied_5",
                    "economics_class_12_ied_6",
                    "economics_class_12_ied_7",
                    "economics_class_12_ied_8"
                )
            )

            // -------------------------------------------------
            // MATHEMATICS - MP BOARD CLASS 12
            // -------------------------------------------------

            "mathematics" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    "Relations and Functions",
                    "Inverse Trigonometric Functions",
                    "Matrices",
                    "Determinants",
                    "Continuity and Differentiability",
                    "Application of Derivatives",
                    "Integrals",
                    "Application of Integrals",
                    "Differential Equations",
                    "Vector Algebra",
                    "Three-Dimensional Geometry",
                    "Linear Programming",
                    "Probability"
                )
            )

            // -------------------------------------------------
            // ENGLISH - MP BOARD CLASS 12
            // -------------------------------------------------

            "english" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    "Reading Skills",
                    "Writing Skills",
                    "Grammar",
                    "Flamingo",
                    "Vistas",
                    "English Grammar MCQs",
                    "English Book-Based MCQs"
                ),
                chapterIds = listOf(
                    "english_class_12_1",
                    "english_class_12_2",
                    "english_class_12_3",
                    "english_class_12_4",
                    "english_class_12_5",
                    "english_class_12_grammar",
                    "english_class_12_book"
                )
            )

            // -------------------------------------------------
            // HINDI - MP BOARD CLASS 12
            // -------------------------------------------------

            "hindi" -> chapters(
                subjectId,
                Board.MP_BOARD,
                ClassLevel.CLASS_12,
                listOf(
                    "आरोह — भाग 2 (काव्य खण्ड)",
                    "काव्य बोध",
                    "आरोह — भाग 2 (गद्य खण्ड)",
                    "भाषा बोध",
                    "वितान भाग — 2",
                    "अभिव्यक्ति और माध्यम — जनसंचार माध्यम और लेखन",
                    "अभिव्यक्ति और माध्यम — सृजनात्मक लेखन",
                    "अपठित बोध",
                    "पत्र एवं निबंध लेखन",
                    "Hindi Grammar MCQs",
                    "Hindi Book-Based MCQs"
                ),
                chapterIds = listOf(
                    "hindi_class_12_1",
                    "hindi_class_12_2",
                    "hindi_class_12_3",
                    "hindi_class_12_4",
                    "hindi_class_12_5",
                    "hindi_class_12_6",
                    "hindi_class_12_7",
                    "hindi_class_12_8",
                    "hindi_class_12_9",
                    "hindi_class_12_grammar",
                    "hindi_class_12_book"
                )
            )

            else -> emptyList()
        }
    }

    // ---------------------------------------------------------
    // CBSE
    // ---------------------------------------------------------

    private fun getCbseChapters(
        subjectId: String,
        classLevel: ClassLevel
    ): List<ChapterData> {

        return when (classLevel) {

            ClassLevel.CLASS_11 -> getCbseClass11Chapters(subjectId)

            ClassLevel.CLASS_12 -> getCbseClass12Chapters(subjectId)
        }
    }

    private fun getCbseClass11Chapters(
        subjectId: String
    ): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction to Accounting",
                    "Theory Base of Accounting",
                    "Recording of Transactions",
                    "Bank Reconciliation Statement",
                    "Trial Balance and Rectification of Errors",
                    "Depreciation",
                    "Bills of Exchange",
                    "Financial Statements of Sole Proprietorship"
                )
            )

            "business_studies" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "Nature and Purpose of Business",
                    "Forms of Business Organisations",
                    "Public, Private and Global Enterprises",
                    "Business Services",
                    "Emerging Modes of Business",
                    "Social Responsibility of Business and Business Ethics",
                    "Sources of Business Finance",
                    "Small Business",
                    "Internal Trade",
                    "International Business"
                )
            )

            "economics" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction",
                    "Collection, Organisation and Presentation of Data",
                    "Statistical Tools and Interpretation",
                    "Introduction to Microeconomics",
                    "Consumer Behaviour and Demand",
                    "Producer Behaviour and Supply",
                    "Perfect Competition",
                    "Market Equilibrium"
                )
            )

            "mathematics" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "Sets",
                    "Relations and Functions",
                    "Trigonometric Functions",
                    "Complex Numbers and Quadratic Equations",
                    "Linear Inequalities",
                    "Permutations and Combinations",
                    "Binomial Theorem",
                    "Sequences and Series",
                    "Straight Lines",
                    "Conic Sections",
                    "Introduction to Three Dimensional Geometry",
                    "Limits and Derivatives",
                    "Statistics",
                    "Probability"
                )
            )

            "english" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "Reading Comprehension",
                    "Grammar",
                    "Creative Writing",
                    "Hornbill",
                    "Snapshots"
                )
            )

            "hindi" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_11,
                listOf(
                    "आरोह",
                    "वितान",
                    "अभिव्यक्ति और माध्यम"
                )
            )

            else -> emptyList()
        }
    }

    private fun getCbseClass12Chapters(
        subjectId: String
    ): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "Accounting for Partnership Firms",
                    "Accounting for Companies",
                    "Analysis of Financial Statements",
                    "Cash Flow Statement"
                )
            )

            "business_studies" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "Nature and Significance of Management",
                    "Principles of Management",
                    "Business Environment",
                    "Planning",
                    "Organising",
                    "Staffing",
                    "Directing",
                    "Controlling",
                    "Financial Management",
                    "Financial Markets",
                    "Marketing Management",
                    "Consumer Protection"
                )
            )

            // -------------------------------------------------
            // CBSE CLASS 12 ECONOMICS
            //
            // Stable subject IDs are now supported:
            //
            // cbse_class_12_economics_macro
            // cbse_class_12_economics_indian
            //
            // Legacy "economics" remains supported so existing
            // legacy callers do not immediately break.
            // -------------------------------------------------

            "cbse_class_12_economics_macro" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "National Income and Related Aggregates",
                    "Money and Banking",
                    "Determination of Income and Employment",
                    "Government Budget and the Economy",
                    "Balance of Payments"
                ),
                chapterIds = listOf(
                    "economics_class_12_macro_1",
                    "economics_class_12_macro_2",
                    "economics_class_12_macro_3",
                    "economics_class_12_macro_4",
                    "economics_class_12_macro_5"
                )
            )

            "cbse_class_12_economics_indian" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "Development Experience (1947–90) and Economic Reforms since 1991",
                    "Current Challenges Facing Indian Economy",
                    "Development Experience of India – A Comparison with Neighbours"
                ),
                chapterIds = listOf(
                    "economics_class_12_ied_1",
                    "economics_class_12_ied_2",
                    "economics_class_12_ied_3"
                )
            )

            // Legacy subject ID.
            //
            // Kept temporarily for backward compatibility with
            // existing screens/callers that still pass "economics".
            "economics" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "National Income and Related Aggregates",
                    "Money and Banking",
                    "Determination of Income and Employment",
                    "Government Budget and the Economy",
                    "Balance of Payments",
                    "Development Experience (1947–90) and Economic Reforms since 1991",
                    "Current Challenges Facing Indian Economy",
                    "Development Experience of India – A Comparison with Neighbours"
                ),
                chapterIds = listOf(
                    "economics_class_12_macro_1",
                    "economics_class_12_macro_2",
                    "economics_class_12_macro_3",
                    "economics_class_12_macro_4",
                    "economics_class_12_macro_5",
                    "economics_class_12_ied_1",
                    "economics_class_12_ied_2",
                    "economics_class_12_ied_3"
                )
            )

            "mathematics" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "Relations and Functions",
                    "Inverse Trigonometric Functions",
                    "Matrices",
                    "Determinants",
                    "Continuity and Differentiability",
                    "Application of Derivatives",
                    "Integrals",
                    "Application of Integrals",
                    "Differential Equations",
                    "Vector Algebra",
                    "Three Dimensional Geometry",
                    "Linear Programming",
                    "Probability"
                )
            )

            "english" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "Reading Comprehension",
                    "Creative Writing Skills",
                    "Flamingo",
                    "Vistas"
                )
            )

            "hindi" -> chapters(
                subjectId,
                Board.CBSE,
                ClassLevel.CLASS_12,
                listOf(
                    "आरोह",
                    "वितान",
                    "अभिव्यक्ति और माध्यम"
                )
            )

            else -> emptyList()
        }
    }

    // ---------------------------------------------------------
    // Common chapter builder
    // ---------------------------------------------------------

    private fun chapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel,
        titles: List<String>,
        chapterIds: List<String>? = null
    ): List<ChapterData> {

        return titles.mapIndexed { index, title ->

            ChapterData(
                id = chapterIds?.getOrNull(index)
                    ?: "${subjectId}_${classLevel.name.lowercase()}_${index + 1}",
                subjectId = subjectId,
                title = title,
                chapterNumber = index + 1,
                board = board,
                classLevel = classLevel
            )
        }
    }
}
