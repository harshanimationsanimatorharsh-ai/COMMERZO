package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty

/**
 * MP Board Class 12 question bank.
 *
 * Accountancy, Business Studies and Economics Micro/Macro questions are sourced
 * from the supplied COMMERZO master MCQ document and interleaved by difficulty
 * within each chapter. Hindi, English and Mathematics contain the requested
 * expanded chapter-wise generated practice set. Existing Economics IED legacy
 * questions are retained for chapter compatibility.
 */
private val BUSINESS_STUDIES_SEEDS = mapOf(
    "1" to listOf(
    Seed("management", "a process of planning, organising, staffing, directing and controlling", "only a sales activity", "only a bookkeeping activity", "only a production activity"),
    Seed("coordination", "the force that binds different organisational activities together", "replacement of planning", "a method of depreciation", "a type of market"),
    Seed("effectiveness", "doing the right things to achieve objectives", "reducing wages only", "increasing paperwork", "avoiding all decisions"),
    Seed("efficiency", "doing work with minimum possible cost and resources", "ignoring resources", "avoiding targets", "stopping production"),
    Seed("management as art", "application of knowledge and skill in practice", "a legal document", "a financial statement", "a market structure"),
),
    "2" to listOf(
    Seed("unity of command", "one employee should receive orders from one superior", "one employee must have many bosses", "all authority must be centralised", "all workers must be equal shareholders"),
    Seed("equity", "fair and kind treatment of employees", "strict punishment in every case", "complete absence of rules", "selling shares"),
    Seed("scalar chain", "formal line of authority from top to bottom", "stock exchange network", "consumer complaint system", "production cycle"),
    Seed("discipline", "obedience to rules and agreements", "absence of standards", "random decision making", "price discrimination"),
    Seed("esprit de corps", "promoting team spirit and harmony", "individual rivalry", "financial auditing", "product branding"),
),
    "3" to listOf(
    Seed("business environment", "the totality of external forces affecting a business", "internal accounting records", "employee attendance only", "factory layout only"),
    Seed("economic environment", "factors such as income, interest rates and economic policies", "office furniture", "company logo", "employee dress code"),
    Seed("technological environment", "changes in technology that can affect business operations", "changes in rainfall only", "employee leave records", "office seating"),
    Seed("political environment", "government policy and political conditions affecting business", "weather forecast", "product packaging", "cash memo"),
    Seed("importance of scanning environment", "it helps identify opportunities and threats", "it eliminates all competition", "it guarantees profit", "it removes all business risk"),
),
    "4" to listOf(
    Seed("planning", "deciding in advance what to do, how to do it and when to do it", "recruiting employees only", "recording transactions only", "designing a logo"),
    Seed("objective", "a desired result that an organisation seeks to achieve", "a tax receipt", "a bank statement", "a stock certificate"),
    Seed("strategy", "a broad plan designed to achieve organisational objectives", "a daily attendance sheet", "a purchase invoice", "a salary slip"),
    Seed("planning limitation", "planning may not work perfectly in a rapidly changing environment", "planning always guarantees profit", "planning removes uncertainty completely", "planning eliminates competition"),
    Seed("decision making", "selecting the most suitable course of action from alternatives", "recording attendance", "printing brochures", "counting inventory only"),
),
    "5" to listOf(
    Seed("organising", "identifying work, grouping activities and establishing authority relationships", "calculating depreciation", "forecasting inflation", "writing advertisements"),
    Seed("delegation", "transfer of authority while ultimate accountability remains with the superior", "complete transfer of accountability", "abolition of authority", "sale of ownership"),
    Seed("decentralisation", "systematic dispersal of decision-making authority to lower levels", "centralising every decision", "removing all managers", "closing branches"),
    Seed("departmentalisation", "grouping related activities into departments", "issuing shares", "calculating GDP", "setting interest rates"),
    Seed("formal organisation", "a deliberately created structure of roles and authority", "friendship network", "informal gossip group", "consumer association"),
),
    "6" to listOf(
    Seed("staffing", "obtaining, developing and maintaining a suitable workforce", "setting product price", "preparing cash flow", "designing packaging"),
    Seed("recruitment", "searching for and attracting prospective employees", "final selection only", "training existing machines", "auditing accounts"),
    Seed("selection", "choosing the most suitable candidate from applicants", "advertising a product", "calculating tax", "setting a budget"),
    Seed("training", "improving employees knowledge and skills for work", "reducing product quality", "closing a department", "issuing shares"),
    Seed("performance appraisal", "systematic evaluation of employee performance", "market research", "cash management", "stock valuation"),
),
    "7" to listOf(
    Seed("directing", "initiating action and guiding employees toward organisational goals", "preparing final accounts", "calculating GDP", "issuing debentures"),
    Seed("motivation", "the process of stimulating people to act toward desired goals", "depreciation of assets", "market segmentation", "inventory valuation"),
    Seed("leadership", "influencing people to willingly work toward organisational goals", "recording transactions", "calculating ratios", "preparing a balance sheet"),
    Seed("communication", "exchange of information and understanding between people", "capital budgeting", "stock valuation", "product costing"),
    Seed("supervision", "overseeing employees work and guiding them", "issuing shares", "setting tax rates", "preparing a trial balance"),
),
    "8" to listOf(
    Seed("controlling", "comparing actual performance with standards and taking corrective action", "recruiting employees", "designing products", "writing advertisements"),
    Seed("standards", "predetermined criteria used to measure performance", "cash receipts", "market shares", "office furniture"),
    Seed("deviation", "difference between actual performance and the standard", "employee promotion", "capital contribution", "product warranty"),
    Seed("corrective action", "steps taken to remove the causes of significant deviations", "random punishment", "stopping all planning", "changing the company name"),
    Seed("relationship of planning and controlling", "planning provides standards and controlling checks performance against them", "they are unrelated", "controlling replaces planning", "planning happens only after controlling"),
),
    "9" to listOf(
    Seed("financial management", "planning, procuring and controlling financial resources", "staff recruitment", "product packaging", "customer service only"),
    Seed("investment decision", "decision about where funds should be invested", "decision about office dress", "decision about advertising language only", "decision about attendance"),
    Seed("financing decision", "decision regarding sources and composition of funds", "decision about product colour", "decision about holidays", "decision about stationery"),
    Seed("capital structure", "mix of debt and equity used to finance a firm", "mix of products", "mix of employees", "mix of customers"),
    Seed("dividend decision", "decision concerning distribution of profits to shareholders", "decision about recruitment", "decision about inventory coding", "decision about product design"),
),
    "10" to listOf(
    Seed("capital market", "market for medium and long-term funds", "market for only vegetables", "market for daily wages", "market for consumer complaints"),
    Seed("money market", "market for short-term funds", "market for permanent capital only", "market for real estate only", "market for labour only"),
    Seed("primary market", "market where new securities are issued", "market for resale of old securities only", "consumer retail market", "foreign exchange only"),
    Seed("secondary market", "market where existing securities are traded", "market where new shares are first issued", "labour market", "product market"),
    Seed("SEBI", "regulator of the securities market in India", "central bank only", "tax department only", "insurance company"),
),
    "11" to listOf(
    Seed("marketing mix", "set of controllable marketing tools used to satisfy target customers", "balance sheet format", "organisation chart", "cash budget"),
    Seed("product", "goods, services or ideas offered to satisfy a need or want", "tax return", "loan agreement", "employee register"),
    Seed("price", "amount of money charged for a product or service", "number of employees", "factory size", "brand colour"),
    Seed("promotion", "activities used to communicate product information and persuade customers", "depreciation method", "capital structure", "cash reserve"),
    Seed("physical distribution", "activities involved in moving products to customers", "employee training", "financial auditing", "tax assessment"),
),
    "12" to listOf(
    Seed("consumer protection", "safeguarding consumers against unfair trade practices", "reducing wages", "raising taxes", "issuing shares"),
    Seed("consumer right to safety", "protection against hazardous goods and services", "right to avoid all payments", "right to unlimited credit", "right to free shares"),
    Seed("consumer right to information", "right to know quality, quantity, price and relevant product information", "right to hide defects", "right to set taxes", "right to appoint directors"),
    Seed("consumer responsibility", "being aware and using products carefully and lawfully", "ignoring bills", "misusing products", "avoiding all information"),
    Seed("redressal", "obtaining remedy for a genuine consumer grievance", "increasing advertising", "raising production", "reducing bookkeeping"),
),
)

private val ECONOMICS_SEEDS = mapOf(
    "micro_1" to listOf(
    Seed("opportunity cost", "value of the next best alternative foregone", "total money spent", "fixed cost", "accounting profit"),
    Seed("scarcity", "limited resources relative to unlimited wants", "unlimited resources", "zero wants", "fixed prices"),
    Seed("positive economics", "study of what is, based on facts and cause-effect relations", "study of what ought to be only", "moral philosophy only", "personal preference"),
    Seed("normative economics", "statements involving value judgements about what ought to be", "purely factual measurement", "accounting record", "population census"),
    Seed("production possibility frontier", "curve showing maximum possible combinations of two goods with given resources and technology", "demand curve only", "supply schedule only", "budget statement"),
),
    "micro_2" to listOf(
    Seed("marginal utility", "additional utility from consuming one more unit", "total cost", "average revenue", "fixed capital"),
    Seed("law of diminishing marginal utility", "marginal utility tends to fall as consumption increases, other things constant", "utility always rises", "price always doubles", "income becomes zero"),
    Seed("consumer equilibrium", "point at which the consumer maximises satisfaction subject to the budget constraint", "firm maximises tax", "government fixes wages", "seller sets stock"),
    Seed("budget set", "set of bundles a consumer can afford", "all impossible bundles", "only luxury goods", "only free goods"),
    Seed("indifference curve", "curve showing combinations of goods giving the same level of satisfaction", "cost curve", "supply curve", "production curve"),
),
    "micro_3" to listOf(
    Seed("marginal product", "change in total product due to one additional unit of variable input", "average cost", "fixed cost", "total revenue"),
    Seed("total product", "total output produced with given inputs", "price of a product", "total expenditure only", "profit rate"),
    Seed("fixed cost", "cost that does not change with output in the short run", "cost that always changes with output", "selling price", "total revenue"),
    Seed("average cost", "cost per unit of output", "total profit", "marginal revenue", "tax rate"),
    Seed("law of variable proportions", "output changes when one input varies while others remain fixed in the short run", "all inputs fixed forever", "price remains fixed", "demand becomes zero"),
),
    "micro_4" to listOf(
    Seed("perfect competition", "market with many buyers and sellers and a homogeneous product", "monopoly", "oligopoly", "monopolistic competition"),
    Seed("price taker", "a firm that accepts the market-determined price", "a firm that always sets any price", "a consumer only", "a regulator"),
    Seed("average revenue", "revenue per unit of output", "total cost per unit only", "fixed cost", "tax revenue"),
    Seed("profit maximisation", "choice of output where the firm seeks the highest possible profit under given conditions", "choice of logo", "choice of employee uniform", "choice of office"),
    Seed("shutdown point", "short-run point where price is insufficient to cover average variable cost", "point of maximum advertising", "point of zero demand always", "point of unlimited profit"),
),
    "micro_5" to listOf(
    Seed("equilibrium price", "price at which quantity demanded equals quantity supplied", "maximum price", "minimum wage", "transfer price"),
    Seed("excess demand", "quantity demanded exceeds quantity supplied at a given price", "quantity supplied exceeds demand", "demand equals supply", "zero demand"),
    Seed("excess supply", "quantity supplied exceeds quantity demanded at a given price", "demand exceeds supply", "demand equals supply", "zero supply"),
    Seed("price ceiling", "legally fixed maximum price", "minimum legal price", "market-determined price only", "export price"),
    Seed("price floor", "legally fixed minimum price", "maximum legal price", "zero price", "foreign price"),
),
    "macro_1" to listOf(
    Seed("macroeconomics", "study of economy-wide aggregates", "individual consumer only", "single firm only", "one product only"),
    Seed("stock variable", "quantity measured at a point of time", "quantity measured only per year", "price index only", "flow of income only"),
    Seed("flow variable", "quantity measured over a period of time", "quantity at one instant only", "fixed asset only", "population at midnight"),
    Seed("economic model", "simplified representation used to analyse economic relationships", "legal contract", "bank account", "company logo"),
    Seed("aggregate", "total or combined measure for an economy", "single household only", "one shop only", "one invoice"),
),
    "macro_2" to listOf(
    Seed("GDP", "market value of final goods and services produced within domestic territory in a period", "national debt", "fiscal deficit", "money supply"),
    Seed("value added", "increase in value created at a stage of production", "total imports only", "tax collection only", "wages only"),
    Seed("real GDP", "GDP measured at constant prices", "GDP at current prices only", "government debt", "money supply"),
    Seed("nominal GDP", "GDP measured at current prices", "GDP at constant prices", "unemployment rate", "fiscal deficit"),
    Seed("double counting", "counting the value of the same output more than once", "counting only final goods", "excluding all services", "measuring inflation"),
),
    "macro_3" to listOf(
    Seed("central bank", "institution responsible for monetary policy and currency management", "stock exchange", "insurance company", "trade union"),
    Seed("commercial bank", "financial institution accepting deposits and providing loans", "tax authority", "central government", "stock exchange"),
    Seed("repo rate", "rate at which the central bank lends short-term funds to commercial banks against eligible securities", "income tax rate", "GST rate", "wage rate"),
    Seed("cash reserve ratio", "fraction of deposits banks must keep as reserves with the central bank", "profit ratio", "export ratio", "capital-output ratio"),
    Seed("money supply", "stock of money available in an economy at a point of time", "total output only", "government expenditure only", "imports only"),
),
    "macro_4" to listOf(
    Seed("aggregate demand", "total planned expenditure on final goods and services in an economy", "tax revenue only", "exports only", "wages only"),
    Seed("multiplier", "ratio of change in income to the initial change in autonomous expenditure", "tax rate", "interest rate only", "exchange rate"),
    Seed("MPC", "change in consumption divided by change in income", "change in investment divided by output", "tax divided by imports", "exports divided by savings"),
    Seed("involuntary unemployment", "unemployment arising when people willing to work cannot find jobs at prevailing conditions", "voluntary retirement", "seasonal holiday", "student absence"),
    Seed("full employment", "situation where all who are willing and able to work at prevailing conditions can find work", "zero unemployment of every kind", "zero vacancies", "zero population"),
),
    "macro_5" to listOf(
    Seed("fiscal deficit", "excess of total expenditure over total receipts excluding borrowings", "revenue surplus", "trade surplus", "current account surplus"),
    Seed("revenue receipt", "receipt that does not create liability or reduce assets of government", "government borrowing", "sale of government asset", "loan recovery"),
    Seed("capital receipt", "receipt that creates liability or reduces assets", "tax revenue", "fees only", "fines only"),
    Seed("revenue expenditure", "expenditure that neither creates assets nor reduces liabilities in the usual budget classification", "construction of a new road", "purchase of machinery", "loan repayment"),
    Seed("fiscal policy", "government policy relating to taxation and public expenditure", "monetary policy only", "trade union policy", "company policy"),
),
    "macro_6" to listOf(
    Seed("balance of payments", "systematic record of economic transactions between residents and the rest of the world", "government budget", "national income statement", "company balance sheet"),
    Seed("current account", "records trade in goods, services, income and current transfers", "only capital transfers", "only foreign loans", "only reserves"),
    Seed("foreign exchange rate", "price of one currency in terms of another", "domestic wage rate", "tax rate", "interest on savings"),
    Seed("depreciation of currency", "fall in the value of a currency under a flexible exchange-rate system", "rise in currency value", "fixed tax rate", "fall in output only"),
    Seed("trade balance", "difference between exports and imports of goods", "difference between taxes and spending", "difference between savings and investment", "difference between wages and profits"),
),
    "ied_1" to listOf(
    Seed("colonial economy", "economy shaped by colonial policies with low industrial development", "fully industrial economy", "planned socialist economy", "high-income service economy"),
    Seed("commercialisation of agriculture", "shift toward producing crops for the market and cash needs", "complete subsistence farming", "zero exports", "industrial licensing"),
    Seed("deindustrialisation", "decline of traditional handicraft and indigenous industries under colonial conditions", "rapid industrialisation", "rise in literacy only", "growth of services only"),
    Seed("drain of wealth", "transfer of economic resources from India to Britain without adequate economic return", "domestic investment", "capital formation", "public borrowing"),
    Seed("occupational structure", "distribution of workers across sectors and activities", "price structure", "tax structure", "banking structure"),
),
    "ied_2" to listOf(
    Seed("mixed economy", "economy combining public and private sectors", "closed barter economy", "pure capitalist economy", "pure subsistence economy"),
    Seed("planning", "deliberate setting of development priorities and targets by the state", "random allocation", "absence of goals", "private advertising"),
    Seed("land reforms", "measures such as tenancy reform and land redistribution", "bank recapitalisation", "trade liberalisation", "currency devaluation"),
    Seed("green revolution", "increase in agricultural productivity associated with high-yielding varieties and complementary inputs", "industrial policy", "bank merger", "foreign exchange reform"),
    Seed("public sector", "sector where ownership or control is substantially with government", "only foreign firms", "household sector", "informal sector only"),
),
    "ied_3" to listOf(
    Seed("liberalisation", "removal or reduction of unnecessary government restrictions on economic activity", "nationalisation", "rationing", "price freezing"),
    Seed("privatisation", "greater role or ownership of private sector in economic activity", "complete government ownership", "price control", "trade ban"),
    Seed("globalisation", "greater integration of an economy with the world economy", "economic isolation", "ban on trade", "complete autarky"),
    Seed("disinvestment", "sale of a part of government ownership in a public enterprise", "purchase of more public shares", "raising tax", "printing currency"),
    Seed("industrial delicensing", "removal of licensing requirements for many industries", "ban on all industries", "mandatory nationalisation", "fixed wages"),
),
    "ied_4" to listOf(
    Seed("human capital", "stock of knowledge, skills and health embodied in people", "physical machines", "land stock", "foreign exchange"),
    Seed("education", "investment that improves knowledge and productive skills", "physical depreciation", "tax collection", "price control"),
    Seed("health", "factor contributing to worker productivity and quality of life", "only a consumer good", "a stock market index", "a tariff"),
    Seed("brain drain", "migration of skilled people to other countries", "rural development", "capital formation", "price rise"),
    Seed("human development", "broader improvement in capabilities and well-being", "only income growth", "only exports", "only tax revenue"),
),
    "ied_5" to listOf(
    Seed("rural development", "process of improving economic and social conditions in rural areas", "urban migration only", "industrial licensing", "exchange control"),
    Seed("rural credit", "financial support needed by rural households and producers", "foreign exchange only", "urban luxury spending", "tax exemption only"),
    Seed("cooperative credit", "credit provided through cooperative institutions", "only moneylenders", "only multinational banks", "only stock exchanges"),
    Seed("diversification of rural employment", "development of non-farm activities alongside agriculture", "ending all non-farm work", "only cash crops", "only imports"),
    Seed("agricultural marketing", "activities involved in assembling, storing, transporting and selling farm produce", "only crop production", "only taxation", "only banking"),
),
    "ied_6" to listOf(
    Seed("disguised unemployment", "employment where removal of some workers does not reduce output", "seasonal inflation", "structural deficit", "trade surplus"),
    Seed("seasonal unemployment", "unemployment occurring during particular seasons due to seasonal work", "permanent retirement", "full employment", "price stability"),
    Seed("informal sector", "sector with many small-scale units and less formal regulation/protection", "only government offices", "only listed companies", "only foreign firms"),
    Seed("worker participation", "share of working-age population engaged in economic activity", "share of exports", "share of taxes", "share of imports"),
    Seed("employment elasticity", "responsiveness of employment to changes in output", "price responsiveness only", "tax responsiveness", "exchange rate"),
),
    "ied_7" to listOf(
    Seed("sustainable development", "development that meets present needs without compromising future generations", "maximum resource extraction", "zero economic activity", "unlimited consumption"),
    Seed("renewable resource", "resource that can regenerate naturally if managed sustainably", "coal only", "petroleum only", "a non-renewable mineral"),
    Seed("externality", "effect of an activity on others not fully reflected in market prices", "private accounting entry", "bank loan", "salary slip"),
    Seed("pollution control", "measures that reduce harmful environmental emissions or waste", "increasing pollution", "removing regulation", "unlimited extraction"),
    Seed("carrying capacity", "maximum level of population or activity an ecosystem can sustain over time", "market share", "tax base", "bank reserve"),
),
    "ied_8" to listOf(
    Seed("human development", "broader measure including health, education and standard of living", "only GDP", "only exports", "only population"),
    Seed("per capita income", "average income per person", "total population only", "total exports", "tax rate"),
    Seed("HDI", "index combining dimensions such as health, education and income", "only stock prices", "only exports", "only inflation"),
    Seed("development experience", "historical path and policy choices affecting economic outcomes", "only weather", "only geography", "only accounting"),
    Seed("comparison indicator", "measure used to compare economic or social outcomes across countries", "company invoice", "single household bill", "office attendance"),
),
)

private val MATHEMATICS_SEEDS = mapOf(
    "1" to listOf(
    Seed("function", "a relation in which every element of the domain has exactly one image", "any subset of codomain", "empty set only", "symmetric relation only"),
    Seed("domain", "set of all input values of a function", "set of outputs only", "range of derivatives", "zero set"),
    Seed("range", "set of actual output values of a function", "all possible inputs", "domain only", "matrix order"),
    Seed("one-one function", "function in which distinct inputs have distinct images", "all inputs have same image", "no output", "every input has two images"),
    Seed("onto function", "function whose range equals its codomain", "function with empty range", "function with no domain", "function with one input only"),
),
    "2" to listOf(
    Seed("principal value of sin⁻¹x", "value lying in [-π/2, π/2]", "value in [0,2π]", "value in [-π,π]", "any real value"),
    Seed("principal value of cos⁻¹x", "value lying in [0,π]", "value in [-π,0]", "value in [0,2π]", "any real value"),
    Seed("principal value of tan⁻¹x", "value lying in (-π/2,π/2)", "value in [0,2π]", "value in [-π,π]", "any real value"),
    Seed("sin⁻¹x domain", "[-1,1]", "all real numbers", "positive reals only", "integers only"),
    Seed("identity sin⁻¹(sin x)", "equals x only when x lies in the principal range", "equals x for every real x", "always equals π", "always equals 0"),
),
    "3" to listOf(
    Seed("identity matrix", "square matrix with ones on principal diagonal and zeros elsewhere", "zero matrix", "row matrix", "column matrix"),
    Seed("order of matrix", "number of rows and columns", "determinant only", "sum of entries", "number of diagonals only"),
    Seed("transpose", "matrix obtained by interchanging rows and columns", "matrix inverse always", "matrix square", "matrix determinant"),
    Seed("symmetric matrix", "matrix satisfying Aᵀ=A", "matrix satisfying Aᵀ=-A", "zero matrix only", "diagonal matrix only"),
    Seed("matrix multiplication", "defined when columns of first matrix equal rows of second", "defined only for equal entries", "never defined for square matrices", "defined only for vectors"),
),
    "4" to listOf(
    Seed("determinant of triangular matrix", "product of its diagonal entries", "sum of all entries", "zero always", "largest entry"),
    Seed("minor of an element", "determinant obtained after deleting its row and column", "row sum", "column sum", "matrix inverse"),
    Seed("cofactor", "signed minor of an element", "absolute value of determinant only", "row product", "column product"),
    Seed("singular matrix", "matrix whose determinant is zero", "matrix with determinant one", "rectangular matrix only", "identity matrix only"),
    Seed("adjoint", "transpose of the cofactor matrix", "inverse of every matrix", "determinant itself", "zero matrix"),
),
    "5" to listOf(
    Seed("continuity at x=a", "limit equals function value at a", "derivative is zero", "function is constant", "limit is infinite"),
    Seed("differentiability", "existence of a finite derivative at the point", "function must be constant", "limit must be zero", "function must be polynomial"),
    Seed("derivative", "instantaneous rate of change of a function", "area only", "total cost only", "determinant"),
    Seed("left derivative", "derivative approached from values less than the point", "derivative at infinity", "right limit only", "average value"),
    Seed("differentiable implies continuous", "a function differentiable at a point is continuous there", "differentiability implies discontinuity", "no relation", "only for constants"),
),
    "6" to listOf(
    Seed("local maximum", "point where function changes from increasing to decreasing under suitable conditions", "point where function is always increasing", "zero domain", "vertical asymptote"),
    Seed("critical point", "point where derivative is zero or does not exist, within the relevant domain", "point where function is undefined only", "point at infinity", "any endpoint only"),
    Seed("increasing function", "function whose values rise as x increases over an interval", "function always decreases", "constant only", "undefined function"),
    Seed("decreasing function", "function whose values fall as x increases over an interval", "function always rises", "constant only", "quadratic only"),
    Seed("rate of change", "derivative represents instantaneous rate of change", "integral only", "determinant only", "matrix order"),
),
    "7" to listOf(
    Seed("indefinite integral", "family of antiderivatives differing by a constant", "single number always", "derivative only", "limit only"),
    Seed("constant of integration", "arbitrary constant added to an indefinite integral", "fixed coefficient", "determinant", "domain"),
    Seed("substitution method", "method that simplifies an integral by replacing a suitable expression with a new variable", "matrix inversion", "probability rule", "linear programming"),
    Seed("integration by parts", "method based on ∫u dv = uv − ∫v du", "product rule only", "quotient rule only", "chain rule only"),
    Seed("fundamental theorem", "connects differentiation and definite integration", "connects matrices and determinants", "defines probability only", "defines vectors only"),
),
    "8" to listOf(
    Seed("area under y=f(x)", "definite integral with appropriate limits when f is non-negative", "ordinary derivative", "matrix product", "determinant"),
    Seed("area between curves", "integral of the appropriate difference of upper and lower functions", "sum of slopes only", "product of matrices", "probability"),
    Seed("definite integral", "number obtained after applying limits to an antiderivative", "family of functions only", "derivative only", "matrix"),
    Seed("geometric area", "non-negative measure of a region", "signed slope only", "determinant", "vector"),
    Seed("intersection points", "points satisfying equations of both curves", "points on neither curve", "only endpoints", "matrix entries"),
),
    "9" to listOf(
    Seed("order of differential equation", "highest order derivative present", "number of variables only", "degree of polynomial", "constant term"),
    Seed("degree of differential equation", "power of highest order derivative after removing radicals/fractions in derivatives as appropriate", "number of constants only", "number of variables", "order itself"),
    Seed("general solution", "solution containing arbitrary constants as required by order", "one numerical value only", "no constants ever", "graph only"),
    Seed("variable separable equation", "equation whose variables can be rearranged into separate sides", "matrix equation", "determinant equation", "probability equation"),
    Seed("initial condition", "condition used to determine constants in a particular solution", "condition for matrix order", "market condition", "tax condition"),
),
    "10" to listOf(
    Seed("unit vector", "vector of magnitude one", "zero vector", "parallel vector only", "position vector only"),
    Seed("dot product", "scalar product of two vectors", "vector product only", "matrix determinant", "ordinary derivative"),
    Seed("cross product", "vector product producing a vector perpendicular to the two vectors", "scalar only", "probability only", "determinant only"),
    Seed("parallel vectors", "vectors having proportional direction components", "vectors always perpendicular", "vectors of zero length only", "random vectors"),
    Seed("section formula", "formula for position vector dividing a line segment in a given ratio", "formula for determinant", "formula for probability", "formula for integration"),
),
    "11" to listOf(
    Seed("direction cosines", "cosines of angles made by a line with coordinate axes", "coordinates of midpoint", "length of segment", "equation of sphere only"),
    Seed("direction ratios", "three numbers proportional to the direction cosines", "area of triangle", "volume only", "matrix entries"),
    Seed("angle between two lines", "angle determined from their direction ratios/cosines", "always 90 degrees", "always 0 degrees", "cannot be found"),
    Seed("shortest distance between skew lines", "minimum distance between non-intersecting non-parallel lines", "sum of lengths", "maximum distance", "zero always"),
    Seed("plane equation", "linear equation representing a plane in three-dimensional space", "quadratic equation only", "matrix inverse", "probability law"),
),
    "12" to listOf(
    Seed("feasible region", "set of points satisfying all constraints", "set of objective coefficients", "only boundary line", "empty graph"),
    Seed("objective function", "linear expression to be maximised or minimised", "constraint only", "random equation", "probability function"),
    Seed("constraint", "linear inequality or equation restricting feasible solutions", "objective value only", "profit only", "matrix determinant"),
    Seed("optimal solution", "feasible solution giving the required maximum or minimum objective value", "any infeasible point", "only origin", "random point"),
    Seed("corner point method", "method evaluating objective function at relevant vertices of feasible region", "method for integration", "matrix method", "probability theorem"),
),
    "13" to listOf(
    Seed("conditional probability P(A|B)", "P(A∩B)/P(B) when P(B)>0", "P(A)+P(B)", "P(A)-P(B)", "P(A)P(B) always"),
    Seed("independent events", "events for which occurrence of one does not change probability of the other", "events that must occur together", "mutually exclusive always", "impossible events"),
    Seed("Bayes theorem", "formula for updating conditional probabilities using prior information", "matrix theorem", "integration rule", "budget rule"),
    Seed("random variable", "variable whose value is determined by outcome of a random experiment", "fixed tax rate", "matrix order", "company name"),
    Seed("binomial distribution", "distribution for a fixed number of independent trials with two outcomes per trial", "continuous normal only", "matrix distribution", "price distribution"),
),
)

private val HINDI_SEEDS = mapOf(
    "1" to listOf(
    Seed("काव्य बोध", "कविता के भाव, भाषा, शिल्प और संदर्भ की समझ", "केवल वर्तनी", "केवल गणित", "केवल पत्र लेखन"),
    Seed("बिंब", "काव्य में शब्दों से उभरने वाला चित्रात्मक अनुभव", "लेखा प्रविष्टि", "वाक्य विराम", "गणितीय सूत्र"),
    Seed("प्रतीक", "ऐसा संकेत जो किसी व्यापक भाव या विचार को व्यक्त करे", "केवल अक्षर", "केवल संख्या", "केवल तारीख"),
    Seed("अलंकार", "काव्य की भाषा को प्रभावशाली बनाने वाला साधन", "केवल अनुच्छेद", "केवल तालिका", "केवल शीर्षक"),
    Seed("काव्य भाषा", "कविता में प्रयुक्त भावपूर्ण और कलात्मक भाषा", "केवल सरकारी भाषा", "केवल वैज्ञानिक सूत्र", "केवल समाचार शीर्षक"),
),
    "2" to listOf(
    Seed("रस", "काव्य में अनुभूत सौन्दर्यात्मक भावानुभूति", "वाक्य की लंबाई", "अंकगणित", "पत्र का प्रारूप"),
    Seed("स्थायी भाव", "रस की निष्पत्ति में प्रमुख आधारभूत भाव", "विराम चिह्न", "अनुच्छेद शीर्षक", "मात्रा गणना"),
    Seed("उपमा", "जिसमें समानता को स्पष्ट रूप से व्यक्त किया जाता है", "जहाँ कोई समानता नहीं", "केवल प्रश्न", "केवल पत्र"),
    Seed("रूपक", "जहाँ उपमेय पर उपमान का सीधा आरोप किया जाता है", "केवल तुक", "केवल छंद गणना", "केवल वर्तनी"),
    Seed("छंद", "कविता की लय और मात्रिक/वर्णिक व्यवस्था से संबंधित विधान", "गद्य का शीर्षक", "पत्र का पता", "समाचार की तारीख"),
),
    "3" to listOf(
    Seed("गद्य बोध", "गद्यांश के कथ्य, भाव और शैली की समझ", "केवल छंद", "केवल मात्रा", "केवल गणना"),
    Seed("कथ्य", "रचना में व्यक्त मुख्य विषय या विचार", "केवल लेखक का नाम", "केवल पृष्ठ संख्या", "केवल विराम"),
    Seed("चरित्र चित्रण", "पात्र के स्वभाव और गुणों का प्रस्तुतीकरण", "केवल शीर्षक", "केवल अनुक्रमणिका", "केवल छंद"),
    Seed("व्यंग्य", "विसंगति या दोष पर प्रभावपूर्ण ढंग से प्रहार करने की शैली", "केवल प्रशंसा", "केवल गणना", "केवल समाचार"),
    Seed("शैली", "लेखक की अभिव्यक्ति का विशिष्ट ढंग", "केवल शब्दकोश", "केवल मात्रा", "केवल पृष्ठ संख्या"),
),
    "4" to listOf(
    Seed("समास", "दो या अधिक शब्दों के संक्षिप्त रूप से बने शब्द की रचना", "वाक्य का विराम", "अनुच्छेद की लंबाई", "कहानी का कथानक"),
    Seed("संधि", "दो वर्णों के मेल से होने वाला परिवर्तन", "पत्र का प्रारूप", "अर्थशास्त्र का नियम", "गणितीय प्रमाण"),
    Seed("पर्यायवाची", "समान या निकट अर्थ वाले शब्द", "विपरीत अर्थ वाले शब्द", "केवल संख्याएँ", "केवल संधि"),
    Seed("विलोम", "विपरीत अर्थ व्यक्त करने वाला शब्द", "समान अर्थ वाला शब्द", "केवल विशेषण", "केवल मुहावरा"),
    Seed("मुहावरा", "विशिष्ट अर्थ देने वाला रूढ़ वाक्यांश", "केवल स्वतंत्र अक्षर", "गणितीय सूत्र", "सरकारी आदेश"),
),
    "5" to listOf(
    Seed("पूरक पाठ", "मुख्य पाठ्यपुस्तक के अतिरिक्त अध्ययन के लिए निर्धारित साहित्य", "केवल शब्दकोश", "केवल व्याकरण", "केवल पत्र"),
    Seed("पाठ का केंद्रीय भाव", "रचना का प्रमुख विचार या संवेदना", "केवल लेखक का पता", "केवल पृष्ठ संख्या", "केवल शब्द गिनती"),
    Seed("संस्मरण", "स्मृति पर आधारित रचनात्मक लेखन", "केवल समाचार", "केवल विज्ञापन", "केवल रिपोर्ट"),
    Seed("रेखाचित्र", "किसी व्यक्ति/वस्तु का शब्दों द्वारा प्रभावपूर्ण चित्रण", "केवल तालिका", "केवल कविता छंद", "केवल पत्र"),
    Seed("आत्मकथात्मकता", "लेखक के अपने जीवन-अनुभवों की उपस्थिति", "केवल काल्पनिक गणना", "केवल सरकारी भाषा", "केवल विज्ञापन"),
),
    "6" to listOf(
    Seed("जनसंचार", "बड़ी संख्या में लोगों तक सूचना पहुँचाने की प्रक्रिया", "व्यक्तिगत डायरी", "गणितीय प्रमाण", "खाता लेखन"),
    Seed("समाचार", "सार्वजनिक महत्त्व की नवीन सूचना", "केवल निजी पत्र", "केवल कविता", "केवल विज्ञापन"),
    Seed("फीचर", "विषय को रोचक और विस्तारपूर्ण ढंग से प्रस्तुत करने वाली रचना", "केवल परीक्षा उत्तर", "केवल लेखा", "केवल सूत्र"),
    Seed("रिपोर्ट", "किसी घटना/स्थिति का तथ्यात्मक विवरण", "केवल कहानी", "केवल कविता", "केवल गणित"),
    Seed("संपादकीय", "समाचार-पत्र का विचारप्रधान लेख जो किसी मुद्दे पर दृष्टिकोण प्रस्तुत करता है", "केवल विज्ञापन", "केवल मौसम तालिका", "केवल पत्र"),
),
    "7" to listOf(
    Seed("सृजनात्मक लेखन", "कल्पना और मौलिक अभिव्यक्ति पर आधारित लेखन", "केवल नकल", "केवल तालिका", "केवल गणना"),
    Seed("कहानी", "कथानक और पात्रों के माध्यम से घटना/अनुभव की रचना", "केवल सूत्र", "केवल समाचार शीर्षक", "केवल शब्द सूची"),
    Seed("निबंध", "किसी विषय पर क्रमबद्ध और विचारपूर्ण गद्य रचना", "केवल एक शब्द", "केवल तालिका", "केवल हस्ताक्षर"),
    Seed("डायरी", "व्यक्तिगत अनुभवों का तिथि-आधारित लेखन", "सरकारी रिपोर्ट", "बैंक खाता", "समाचार विज्ञापन"),
    Seed("विज्ञापन लेखन", "कम शब्दों में आकर्षक ढंग से उत्पाद/सेवा/संदेश प्रस्तुत करना", "केवल लंबी शोध रिपोर्ट", "केवल गणितीय प्रमाण", "केवल पत्र"),
),
    "8" to listOf(
    Seed("अपठित गद्यांश", "पहले से न पढ़े गए पाठ को समझकर प्रश्नों के उत्तर देना", "केवल कविता याद करना", "केवल शब्दकोश देखना", "केवल निबंध लिखना"),
    Seed("शीर्षक चयन", "गद्यांश के केंद्रीय भाव से उपयुक्त शीर्षक चुनना", "सबसे लंबा शब्द चुनना", "पहला शब्द चुनना", "कोई भी नाम चुनना"),
    Seed("मुख्य विचार", "पाठ में प्रमुख रूप से व्यक्त बात", "केवल उदाहरण", "केवल एक शब्द", "केवल लेखक की जन्मतिथि"),
    Seed("निहित अर्थ", "पाठ से तार्किक रूप से समझ में आने वाला अप्रत्यक्ष अर्थ", "बिना पाठ के अनुमान", "केवल वर्तनी", "केवल शीर्षक"),
    Seed("संदर्भानुसार अर्थ", "वाक्य के प्रसंग के आधार पर शब्द/वाक्यांश का अर्थ", "शब्दकोश को बिना संदर्भ पढ़ना", "केवल समान शब्द", "केवल विपरीत शब्द"),
),
    "9" to listOf(
    Seed("औपचारिक पत्र", "निश्चित उद्देश्य और औपचारिक शैली में लिखा पत्र", "मित्र को अनौपचारिक संदेश", "केवल कविता", "केवल संवाद"),
    Seed("पत्र का विषय", "पत्र के उद्देश्य को संक्षेप में बताने वाला विषय/शीर्षक", "लेखक की जन्मतिथि", "केवल हस्ताक्षर", "पृष्ठ संख्या"),
    Seed("निबंध की भूमिका", "विषय का संक्षिप्त परिचय देने वाला प्रारम्भिक भाग", "केवल निष्कर्ष", "केवल शीर्षक", "केवल हस्ताक्षर"),
    Seed("निबंध का निष्कर्ष", "मुख्य विचारों को समेटते हुए अंतिम भाग", "केवल पहला वाक्य", "केवल पता", "केवल तारीख"),
    Seed("भाषा की उपयुक्तता", "विषय और पाठक के अनुसार स्पष्ट, शुद्ध और सुसंगत भाषा", "अर्थहीन कठिन शब्द", "जानबूझकर अशुद्ध वर्तनी", "केवल अंग्रेजी शब्द"),
),
)

private val ENGLISH_SEEDS = mapOf(
    "1" to listOf(
    Seed("skimming", "reading quickly to get the main idea", "reading every word", "copying text", "memorising grammar"),
    Seed("scanning", "reading to locate specific information", "reading without purpose", "rewriting the passage", "memorising the title"),
    Seed("inference", "a logical conclusion drawn from clues in a text", "a random guess", "a spelling rule", "a punctuation mark"),
    Seed("tone", "the writers attitude or feeling conveyed through language", "page number", "word count", "font size"),
    Seed("main idea", "the central point of a passage", "one minor detail", "the title alone", "the longest sentence"),
),
    "2" to listOf(
    Seed("formal letter", "structured written communication following a formal format", "personal diary", "poem only", "oral conversation"),
    Seed("letter subject", "brief line stating the purpose of a formal letter", "the writers age", "page number", "signature only"),
    Seed("notice", "a concise public announcement containing essential details", "a long story", "a personal diary", "a poem"),
    Seed("report writing", "factual and organised presentation of an event or situation", "fiction only", "dialogue only", "random notes"),
    Seed("article", "a structured piece of writing presenting information or views on a topic", "a bank statement", "a formula", "a single word"),
),
    "3" to listOf(
    Seed("subject-verb agreement", "the verb agrees with its subject in number and person", "tense agreement only", "punctuation only", "paragraph length"),
    Seed("reported speech", "reporting what someone said without quoting the exact words", "direct quotation only", "a noun phrase", "a paragraph title"),
    Seed("active voice", "the subject performs the action of the verb", "the subject receives the action only", "a question tag", "a preposition"),
    Seed("modal verb", "a verb expressing ideas such as ability, possibility, permission or obligation", "a noun only", "a punctuation mark", "a conjunction only"),
    Seed("conditional sentence", "a sentence expressing a condition and its possible result", "a sentence with no verb", "a title only", "a list of nouns"),
),
    "4" to listOf(
    Seed("literary text", "prose or poetry studied for theme, character, language and interpretation", "only grammar", "only vocabulary list", "only handwriting"),
    Seed("theme", "central idea explored in a literary work", "page number", "publisher address", "word count"),
    Seed("characterisation", "the way a writer presents a characters qualities", "punctuation only", "chapter numbering", "printing format"),
    Seed("imagery", "language that creates sensory or vivid mental pictures", "only spelling", "only dates", "only headings"),
    Seed("irony", "contrast between expected and actual meaning or outcome in context", "literal repetition only", "mathematical equality", "dictionary order"),
),
    "5" to listOf(
    Seed("supplementary reader", "additional prescribed literary texts for study", "dictionary", "grammar workbook", "writing notebook"),
    Seed("narrative", "a structured account of events or experiences", "a punctuation mark", "a formula", "a word list"),
    Seed("setting", "time and place in which a story occurs", "the authors signature", "the page count", "the grammar rule"),
    Seed("conflict", "a struggle between opposing forces or interests in a narrative", "a spelling pattern", "a title", "a bibliography"),
    Seed("point of view", "the perspective from which a narrative is presented", "font size", "page margin", "word count"),
),
)

private val HINDI_GRAMMAR_SEEDS = listOf(
    Seed("संधि", "वर्णों के मेल से होने वाला परिवर्तन", "वाक्य की लंबाई", "गणितीय नियम", "पत्र का पता"),
    Seed("समास", "शब्दों को संक्षिप्त रूप में जोड़ने की प्रक्रिया", "केवल विराम", "केवल संख्या", "केवल छंद"),
    Seed("तत्सम", "संस्कृत से यथावत/निकट रूप में आए शब्द", "विलोम शब्द", "मुहावरा", "अंग्रेजी शब्द"),
    Seed("अलंकार", "भाषा की कलात्मकता बढ़ाने वाला काव्य उपकरण", "लेखा नियम", "बजट नियम", "गणितीय सूत्र"),
    Seed("वाक्य शुद्धि", "व्याकरण की दृष्टि से अशुद्धि दूर कर सही वाक्य बनाना", "केवल शीर्षक बदलना", "केवल शब्द गिनना", "केवल पृष्ठ बदलना"),
)

private val ENGLISH_GRAMMAR_SEEDS = listOf(
    Seed("subject-verb agreement", "the verb agrees with the subject in number and person", "the adjective agrees with a noun only", "punctuation rule", "paragraph length"),
    Seed("tense", "form of a verb indicating time of an action or state", "page layout", "noun count", "letter address"),
    Seed("article", "a, an or the used before nouns in appropriate contexts", "a punctuation mark", "a verb tense", "a paragraph"),
    Seed("preposition", "word showing relation such as time, place or direction", "a noun only", "a sentence ending", "a title"),
    Seed("conjunction", "word used to connect words, phrases or clauses", "a pronoun only", "a tense marker only", "a page heading"),
)

private val ENGLISH_BOOK_SEEDS = listOf(
    Seed("theme", "central idea explored in a prescribed literary work", "page number", "font size", "publisher address"),
    Seed("characterisation", "presentation of a characters qualities and development", "punctuation", "word count", "chapter number"),
    Seed("setting", "time and place of a narrative", "author signature", "grammar rule", "page margin"),
    Seed("narrative", "structured account of events or experiences", "a formula", "a word list", "a punctuation mark"),
    Seed("imagery", "language creating vivid sensory pictures", "only spelling", "only dates", "only headings"),
    Seed("irony", "contrast between expected and actual meaning or outcome", "literal repetition", "mathematical equality", "dictionary order"),
    Seed("conflict", "struggle between opposing forces in a narrative", "a spelling pattern", "a title", "a bibliography"),
    Seed("point of view", "perspective from which a narrative is presented", "font size", "page margin", "word count"),
    Seed("symbol", "object or detail representing a broader idea", "page number", "grammar tense", "publisher address"),
    Seed("tone", "writers attitude conveyed through language", "word count", "chapter number", "font style"),
)

private data class Seed(
    val concept: String,
    val correct: String,
    val distractor1: String,
    val distractor2: String,
    val distractor3: String
)

private fun makeGeneratedQuestions(
    subjectId: String,
    chapterId: String,
    title: String,
    seeds: List<Seed>,
    count: Int,
    category: String,
    idPrefix: String
): List<Question> {
    val stems = listOf(
        "Which statement correctly describes %s?",
        "In %s, which option is most closely associated with %s?",
        "Which is the most appropriate meaning of %s?",
        "Which option identifies the key idea of %s?",
        "For MP Board Class 12, which statement about %s is correct?",
        "Which option best applies the concept of %s?"
    )
    return List(count) { index ->
        val seed = seeds[index % seeds.size]
        val options = listOf(seed.correct, seed.distractor1, seed.distractor2, seed.distractor3)
        val shift = index % 4
        val rotated = options.drop(shift) + options.take(shift)
        val correctIndex = (4 - shift) % 4
        val questionText = when (index % stems.size) {
            1 -> stems[index % stems.size].format(title, seed.concept)
            else -> stems[index % stems.size].format(seed.concept)
        }
        Question(
            id = "${idPrefix}_${index + 1}",
            question = questionText,
            options = rotated,
            correctAnswer = correctIndex,
            explanation = rotated[correctIndex] + ".",
            subjectId = subjectId,
            chapterId = chapterId,
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = when (index % 3) {
                0 -> QuestionDifficulty.EASY
                1 -> QuestionDifficulty.MEDIUM
                else -> QuestionDifficulty.HARD
            },
            tags = listOf("class12", "mp_board", "mcq", category, "mixed_difficulty")
        )
    }
}

class QuestionRepository {



    fun getQuestions(subjectId: String, chapterId: String, board: Board = Board.MP_BOARD, classLevel: ClassLevel = ClassLevel.CLASS_12): List<Question> =
        questionBank().filter { it.subjectId == subjectId && it.chapterId == chapterId && it.board == board && it.classLevel == classLevel }

    fun getQuestions(subjectId: String, chapterId: String): List<Question> =
        getQuestions(subjectId, chapterId, Board.MP_BOARD, ClassLevel.CLASS_12)

    private fun questionBank(): List<Question> = buildList {
        add(Question(
                    id = "accountancy_class_12_1_m0001",
                    question = "Partnership deed is primarily prepared to:",
                    options = listOf(
                        "Calculate sales",
                        "Define rights and duties of partners",
                        "Calculate market value of assets",
                        "Determine cash balance"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0002",
                    question = "A and B share profits in the ratio 3:2. The firm earns ₹50,000. B's share will be:",
                    options = listOf(
                        "₹20,000",
                        "₹25,000",
                        "₹30,000",
                        "₹15,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0003",
                    question = "A and B share profits in the ratio 3:2. Their capitals are ₹5,00,000 and ₹4,00,000. Interest on capital is 10% p.a. Profit before interest is ₹70,000. The amount of profit available after interest on capital is:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹50,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0004",
                    question = "In the absence of a partnership deed, profits and losses are shared:",
                    options = listOf(
                        "In capital ratio",
                        "In old ratio",
                        "Equally",
                        "In current ratio"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0005",
                    question = "P and Q have capitals of ₹4,00,000 and ₹3,00,000. The deed provides interest on capital @10% p.a. If profit is ₹50,000, total interest on capital is:",
                    options = listOf(
                        "₹50,000",
                        "₹70,000",
                        "₹40,000",
                        "₹30,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0006",
                    question = "A and B share profits 3:2. A is guaranteed a minimum profit of ₹36,000. Firm's profit is ₹50,000. A's normal share is ₹30,000. B bears the deficiency alone. B's share after guarantee will be:",
                    options = listOf(
                        "₹14,000",
                        "₹16,000",
                        "₹20,000",
                        "₹24,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0007",
                    question = "Interest on partner's capital is allowed only when:",
                    options = listOf(
                        "Firm earns profit",
                        "Partnership deed provides for it",
                        "Partner demands it",
                        "Capital is fixed"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0008",
                    question = "A withdraws ₹5,000 at the beginning of every month. For calculating interest on drawings, the average period is:",
                    options = listOf(
                        "5.5 months",
                        "6 months",
                        "6.5 months",
                        "12 months"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0009",
                    question = "A withdraws ₹8,000 at the beginning of each quarter. Interest on drawings is 10% p.a. The amount of interest on drawings is:",
                    options = listOf(
                        "₹2,400",
                        "₹2,800",
                        "₹3,000",
                        "₹3,200"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0010",
                    question = "In the absence of an agreement, interest on drawings is:",
                    options = listOf(
                        "Charged at 6%",
                        "Charged at 10%",
                        "Not charged",
                        "Charged at bank rate"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0011",
                    question = "A partner withdraws ₹10,000 at the end of every month. The average period for interest on drawings is:",
                    options = listOf(
                        "5.5 months",
                        "6 months",
                        "6.5 months",
                        "12 months"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0012",
                    question = "A withdraws ₹12,000 at the end of each quarter. Interest on drawings is 8% p.a. Interest on drawings will be:",
                    options = listOf(
                        "₹720",
                        "₹960",
                        "₹1,200",
                        "₹1,440"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0013",
                    question = "A partner's loan to the firm, in the absence of an agreement, carries interest at:",
                    options = listOf(
                        "5% p.a.",
                        "6% p.a.",
                        "8% p.a.",
                        "No interest"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0014",
                    question = "X and Y share profits equally. X is guaranteed ₹30,000. The firm's profit is ₹50,000. X's normal share is ₹25,000. The deficiency is:",
                    options = listOf(
                        "₹2,500",
                        "₹5,000",
                        "₹10,000",
                        "Nil"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0015",
                    question = "A and B share profits 3:2. A is guaranteed ₹40,000. The firm's profit is ₹60,000. The deficiency is borne by A himself. What amount will B receive?",
                    options = listOf(
                        "₹20,000",
                        "₹24,000",
                        "₹30,000",
                        "₹36,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0016",
                    question = "Interest on capital is an example of:",
                    options = listOf(
                        "Charge against profit",
                        "Appropriation of profit",
                        "Asset",
                        "Liability towards outsiders"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0017",
                    question = "A partner's capital is ₹2,00,000. Interest on capital is 8% p.a. The interest credited will be:",
                    options = listOf(
                        "₹8,000",
                        "₹12,000",
                        "₹16,000",
                        "₹20,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0018",
                    question = "A and B share profits 2:1. Profit before appropriations is ₹90,000. Interest on capital is ₹10,000 for A and ₹5,000 for B. A is also entitled to salary ₹15,000. Profit available for distribution after appropriations is:",
                    options = listOf(
                        "₹60,000",
                        "₹70,000",
                        "₹75,000",
                        "₹90,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0019",
                    question = "Interest on drawings is:",
                    options = listOf(
                        "Income for the firm",
                        "Expense of the firm",
                        "Asset of partner",
                        "Loss on revaluation"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0020",
                    question = "A and B share profits 5:3. C is guaranteed ₹12,000 as his minimum share. If C's actual share is ₹9,000 and A bears the deficiency alone, A's profit is reduced by:",
                    options = listOf(
                        "₹1,000",
                        "₹2,000",
                        "₹3,000",
                        "₹4,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0021",
                    question = "A and B share profits equally. A's drawings are ₹10,000 at the beginning of each month. B withdraws ₹20,000 at the end of each quarter. If interest is 6% p.a., the difference between their interest on drawings is:",
                    options = listOf(
                        "₹300",
                        "₹450",
                        "₹600",
                        "₹750"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0022",
                    question = "If a partner is guaranteed a minimum profit, the deficiency is generally borne by:",
                    options = listOf(
                        "All creditors",
                        "The firm automatically",
                        "The partner(s) specified in the guarantee",
                        "Government"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0023",
                    question = "If a partner withdraws ₹24,000 uniformly throughout the year, the average period for interest on drawings is generally:",
                    options = listOf(
                        "3 months",
                        "6 months",
                        "9 months",
                        "12 months"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0024",
                    question = "A and B share profits 3:2. A gets a salary of ₹20,000 and interest on capital of ₹10,000. B gets interest on capital of ₹5,000. Profit before these appropriations is ₹75,000. The residual profit is:",
                    options = listOf(
                        "₹40,000",
                        "₹45,000",
                        "₹50,000",
                        "₹55,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0025",
                    question = "Profit and Loss Appropriation Account is prepared to show:",
                    options = listOf(
                        "Trading profit only",
                        "Distribution of profit among partners",
                        "Cash transactions",
                        "Purchase of fixed assets"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0026",
                    question = "When interest on drawings is charged, the partner's capital/current account is generally:",
                    options = listOf(
                        "Credited",
                        "Debited",
                        "Closed",
                        "Not affected"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0027",
                    question = "A and B share profits 5:3. A is guaranteed ₹30,000. The firm earns ₹56,000. A's normal share is ₹35,000. Which statement is correct?",
                    options = listOf(
                        "A receives ₹30,000",
                        "A receives ₹35,000 and no deficiency arises",
                        "B compensates A ₹5,000",
                        "Firm bears ₹5,000 deficiency"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0028",
                    question = "If the partnership deed is silent about salary to partners, partner's salary is:",
                    options = listOf(
                        "₹5,000 p.m.",
                        "₹10,000 p.m.",
                        "Not allowed",
                        "Allowed at market rate"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0029",
                    question = "A partner is entitled to remuneration of ₹8,000 per month according to the deed. Annual remuneration will be:",
                    options = listOf(
                        "₹80,000",
                        "₹88,000",
                        "₹96,000",
                        "₹1,08,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_1_m0030",
                    question = "A partner's drawings are ₹6,000 at the beginning of every month. If interest on drawings is 12% p.a., the annual interest on drawings is:",
                    options = listOf(
                        "₹3,960",
                        "₹4,320",
                        "₹4,680",
                        "₹5,040"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_1",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0031",
                    question = "Goodwill is classified as:",
                    options = listOf(
                        "Tangible asset",
                        "Intangible asset",
                        "Current liability",
                        "Fictitious asset"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0032",
                    question = "A and B share profits in the ratio 3:2. C is admitted for 1/5 share, acquired equally from A and B. The new ratio will be:",
                    options = listOf(
                        "5:3:2",
                        "2:1:2",
                        "2:1:1",
                        "3:2:1"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0033",
                    question = "A and B share profits 3:2. C is admitted for 1/5 share, acquired equally from A and B. Goodwill of the firm is ₹1,50,000. The amount of goodwill attributable to A's sacrifice is:",
                    options = listOf(
                        "₹10,000",
                        "₹15,000",
                        "₹20,000",
                        "₹25,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0034",
                    question = "Goodwill mainly represents the:",
                    options = listOf(
                        "Cash balance of the firm",
                        "Reputation and earning capacity of the firm",
                        "Total liabilities of the firm",
                        "Physical assets of the firm"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0035",
                    question = "A and B share profits 3:2. C is admitted for 1/5 share, which he acquires entirely from A. The new ratio is:",
                    options = listOf(
                        "2:2:1",
                        "1:2:2",
                        "3:1:1",
                        "2:3:1"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0036",
                    question = "Average profit is ₹1,20,000. Capital employed is ₹8,00,000 and normal rate of return is 10%. Goodwill is valued at 3 years' purchase of super profit. Goodwill is:",
                    options = listOf(
                        "₹60,000",
                        "₹96,000",
                        "₹1,20,000",
                        "₹1,44,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0037",
                    question = "A new partner is admitted into a firm mainly with the consent of:",
                    options = listOf(
                        "New partner only",
                        "Any one existing partner",
                        "All existing partners",
                        "Creditors"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0038",
                    question = "Average profit of a firm is ₹60,000 and goodwill is valued at three years' purchase. Goodwill is:",
                    options = listOf(
                        "₹1,20,000",
                        "₹1,50,000",
                        "₹1,80,000",
                        "₹2,40,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0039",
                    question = "A and B share profits 5:3. C is admitted for 1/4 share, acquired from A and B in the ratio 2:1. The new ratio of A:B:C is:",
                    options = listOf(
                        "11:7:6",
                        "13:8:6",
                        "13:7:4",
                        "10:6:4"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0040",
                    question = "The new partner brings goodwill primarily to compensate the:",
                    options = listOf(
                        "Gaining partners",
                        "Sacrificing partners",
                        "Creditors",
                        "Employees"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0041",
                    question = "Average profit is ₹80,000. Capital employed is ₹5,00,000 and normal rate of return is 10%. Super profit is:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹50,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0042",
                    question = "A and B share profits 3:2. C is admitted for 1/5 share. C brings ₹50,000 as capital and ₹20,000 as goodwill premium. The implied total capital of the firm after admission, based on C's capital, is:",
                    options = listOf(
                        "₹1,50,000",
                        "₹2,00,000",
                        "₹2,50,000",
                        "₹3,00,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0043",
                    question = "Sacrificing ratio is calculated as:",
                    options = listOf(
                        "New ratio − Old ratio",
                        "Old ratio − New ratio",
                        "Old ratio + New ratio",
                        "New ratio ÷ Old ratio"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0044",
                    question = "Super profit is ₹30,000 and years' purchase is 4. Goodwill under the Super Profit Method is:",
                    options = listOf(
                        "₹60,000",
                        "₹90,000",
                        "₹1,20,000",
                        "₹1,50,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0045",
                    question = "Average profit of a firm is ₹90,000. Capital employed is ₹6,00,000 and normal rate of return is 12%. Goodwill is valued at 4 years' purchase of super profit. Goodwill equals:",
                    options = listOf(
                        "₹48,000",
                        "₹60,000",
                        "₹72,000",
                        "₹96,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0046",
                    question = "If goodwill is valued at ₹50,000 and a new partner gets 1/5 share, his share of goodwill is:",
                    options = listOf(
                        "₹5,000",
                        "₹10,000",
                        "₹15,000",
                        "₹20,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0047",
                    question = "A firm has capital employed of ₹6,00,000. Normal rate of return is 10%. Its normal profit is:",
                    options = listOf(
                        "₹6,000",
                        "₹60,000",
                        "₹66,000",
                        "₹70,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0048",
                    question = "A and B share profits 3:2. C is admitted for 1/4 share, which he acquires 3/20 from A and 1/20 from B. The new ratio is:",
                    options = listOf(
                        "9:9:7",
                        "9:7:4",
                        "3:2:1",
                        "12:8:5"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0049",
                    question = "Under the Average Profit Method, goodwill is calculated using:",
                    options = listOf(
                        "Average profit and years' purchase",
                        "Capital and interest rate only",
                        "Assets and liabilities only",
                        "Sales and purchases only"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0050",
                    question = "A and B share profits 5:3. C is admitted for 1/4 share, acquired equally from A and B. A's sacrifice is:",
                    options = listOf(
                        "1/8",
                        "1/10",
                        "1/12",
                        "1/16"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0051",
                    question = "A firm's average profit is ₹1,50,000. Normal rate of return is 10% and capitalised value of the business based on average profit is ₹12,00,000. The capital employed is:",
                    options = listOf(
                        "₹10,00,000",
                        "₹12,00,000",
                        "₹15,00,000",
                        "₹18,00,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0052",
                    question = "Super Profit is calculated as:",
                    options = listOf(
                        "Normal Profit − Actual Profit",
                        "Actual Profit − Normal Profit",
                        "Capital − Profit",
                        "Sales − Expenses"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0053",
                    question = "If the new partner does not bring goodwill in cash but goodwill is to be adjusted through capital accounts, the adjustment is made in favour of:",
                    options = listOf(
                        "Gaining partners",
                        "Sacrificing partners",
                        "New partner",
                        "Creditors"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0054",
                    question = "Average profit is ₹1,20,000 and normal rate of return is 10%. Capital employed is ₹10,00,000. If goodwill is valued at 3 years' purchase of super profit, goodwill is:",
                    options = listOf(
                        "₹30,000",
                        "₹60,000",
                        "₹90,000",
                        "₹1,20,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0055",
                    question = "Normal Profit is calculated by applying the normal rate of return on:",
                    options = listOf(
                        "Drawings",
                        "Capital employed",
                        "Sales",
                        "Goodwill"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0056",
                    question = "A firm's average profit is ₹1,00,000 and normal profit is ₹70,000. Super profit equals:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹70,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0057",
                    question = "A and B share profits 4:3. C is admitted for 1/7 share, acquired from A and B in their old ratio. The new ratio will be:",
                    options = listOf(
                        "3:3:1",
                        "4:3:1",
                        "3:2:1",
                        "2:2:1"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0058",
                    question = "When a new partner brings goodwill in cash, the amount is credited to the:",
                    options = listOf(
                        "Gaining partners' capital accounts",
                        "Sacrificing partners' capital accounts",
                        "New partner's drawings account",
                        "Cash account"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0059",
                    question = "If goodwill is valued at ₹2,40,000 and the incoming partner acquires 1/6 share, the premium for goodwill is:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹60,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_2_m0060",
                    question = "A and B share profits 3:2. C is admitted for 1/5 share. After admission, A's share becomes 1/2. The share sacrificed by B is:",
                    options = listOf(
                        "1/20",
                        "1/10",
                        "3/20",
                        "1/5"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_2",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0061",
                    question = "On retirement of a partner, the retiring partner is entitled to:",
                    options = listOf(
                        "His share of goodwill",
                        "His share of reserves",
                        "His share of revaluation profit/loss",
                        "All of these"
                    ),
                    correctAnswer = 3,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0062",
                    question = "A, B and C share profits in the ratio 3:2:1. C retires and A and B decide to share future profits equally. A's gain is:",
                    options = listOf(
                        "1/6",
                        "1/12",
                        "1/3",
                        "1/4"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0063",
                    question = "A, B and C share profits 5:3:2. C retires. A and B decide to share future profits in the ratio 3:2. The gaining ratio of A and B is:",
                    options = listOf(
                        "1:1",
                        "1:2",
                        "2:1",
                        "3:2"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0064",
                    question = "The ratio in which the remaining partners acquire the retiring partner's share is called:",
                    options = listOf(
                        "Sacrificing ratio",
                        "Gaining ratio",
                        "Capital ratio",
                        "Current ratio"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0065",
                    question = "A, B and C share profits 5:3:2. C retires. A and B continue in the ratio 3:2. The gaining ratio of A and B is:",
                    options = listOf(
                        "1:1",
                        "2:3",
                        "3:2",
                        "5:3"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0066",
                    question = "A, B and C share profits 3:2:1. C retires. A acquires 1/12 of C's share and B acquires the remaining share. The gaining ratio of A and B is:",
                    options = listOf(
                        "1:1",
                        "1:2",
                        "1:3",
                        "2:1"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0067",
                    question = "Gaining ratio is calculated as:",
                    options = listOf(
                        "Old ratio − New ratio",
                        "New ratio − Old ratio",
                        "Old ratio + New ratio",
                        "Capital ratio − New ratio"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0068",
                    question = "A retiring partner's capital account has a credit balance of ₹80,000. His share of goodwill is ₹20,000 and share of revaluation profit is ₹5,000. Amount due before any other adjustment is:",
                    options = listOf(
                        "₹85,000",
                        "₹95,000",
                        "₹1,00,000",
                        "₹1,05,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0069",
                    question = "A, B and C share profits 4:3:2. C retires. Goodwill of the firm is ₹90,000. A and B acquire C's share in the ratio 2:1. The amount of goodwill borne by A is:",
                    options = listOf(
                        "₹10,000",
                        "₹15,000",
                        "₹20,000",
                        "₹30,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0070",
                    question = "On retirement, goodwill adjustment is made in favour of the:",
                    options = listOf(
                        "Gaining partners",
                        "Sacrificing partners",
                        "Retiring partner",
                        "Creditors"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0071",
                    question = "A, B and C share profits 4:3:2. C retires. A and B acquire C's share in the ratio 2:1. Their gaining ratio is:",
                    options = listOf(
                        "2:1",
                        "4:3",
                        "3:2",
                        "1:1"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0072",
                    question = "A, B and C share profits 3:2:1. C retires. Goodwill is ₹1,20,000. A and B decide to share future profits equally. The amount of goodwill adjustment between A and B will be:",
                    options = listOf(
                        "₹5,000",
                        "₹10,000",
                        "₹20,000",
                        "₹30,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0073",
                    question = "Profit or loss on revaluation at the time of retirement is transferred to:",
                    options = listOf(
                        "Remaining partners only",
                        "Retiring partner only",
                        "All partners in their old profit-sharing ratio",
                        "New partners only"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0074",
                    question = "A partner's share of goodwill is ₹30,000. The retiring partner is paid this amount by the gaining partners. The entry involves:",
                    options = listOf(
                        "Debit gaining partners, credit retiring partner",
                        "Debit retiring partner, credit gaining partners",
                        "Debit goodwill, credit cash only",
                        "Debit cash, credit gaining partners"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0075",
                    question = "A, B and C share profits 5:3:2. B retires. A and C agree to share future profits 3:2. The gaining ratio of A and C is:",
                    options = listOf(
                        "1:1",
                        "2:1",
                        "3:2",
                        "5:2"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0076",
                    question = "On retirement, accumulated profits are transferred to partners' capital/current accounts in their:",
                    options = listOf(
                        "New ratio",
                        "Gaining ratio",
                        "Old profit-sharing ratio",
                        "Capital ratio"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0077",
                    question = "At retirement, an increase in the value of an asset is recorded by:",
                    options = listOf(
                        "Debiting Revaluation A/c",
                        "Crediting Revaluation A/c",
                        "Debiting Capital A/c",
                        "Crediting Drawings A/c"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0078",
                    question = "A, B and C share profits 2:3:5. B retires. A and C decide to share future profits in the ratio 1:2. The gaining ratio of A and C is:",
                    options = listOf(
                        "1:1",
                        "1:2",
                        "2:1",
                        "3:2"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0079",
                    question = "On the death of a partner, the amount due to the deceased partner is transferred to:",
                    options = listOf(
                        "His drawings account",
                        "His executor's account",
                        "Revaluation account",
                        "Goodwill account"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0080",
                    question = "At retirement, a decrease in the value of an asset is:",
                    options = listOf(
                        "Credited to Revaluation A/c",
                        "Debited to Revaluation A/c",
                        "Credited to Capital A/c directly",
                        "Ignored"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0081",
                    question = "A, B and C share profits 3:2:1. C dies on 30 June. The firm's profit for the previous year was ₹1,20,000. If profit is assumed to accrue evenly, C's share of profit up to death is:",
                    options = listOf(
                        "₹5,000",
                        "₹10,000",
                        "₹15,000",
                        "₹20,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0082",
                    question = "The deceased partner's share of profit up to the date of death is calculated because:",
                    options = listOf(
                        "It is his entitlement",
                        "It is a liability to creditors",
                        "It is a business expense",
                        "It is transferred to goodwill"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0083",
                    question = "A, B and C share profits equally. C retires. A and B continue equally. C's share is acquired by A and B:",
                    options = listOf(
                        "In the ratio 2:1",
                        "In the ratio 1:2",
                        "Equally",
                        "In capital ratio"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0084",
                    question = "A, B and C share profits 4:3:2. B dies after 3 months. Previous year's profit was ₹1,80,000. Assuming profit accrues evenly, B's share of profit up to death is:",
                    options = listOf(
                        "₹10,000",
                        "₹15,000",
                        "₹20,000",
                        "₹30,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0085",
                    question = "The amount due to a retiring partner may be paid:",
                    options = listOf(
                        "Immediately",
                        "In instalments",
                        "Transferred to his loan account",
                        "Any of these, according to agreement"
                    ),
                    correctAnswer = 3,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0086",
                    question = "If the retiring partner's dues are not paid immediately and transferred to his loan account, the loan account represents:",
                    options = listOf(
                        "An asset of the firm",
                        "A liability of the firm",
                        "An expense",
                        "A reserve"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0087",
                    question = "A, B and C share profits 3:2:1. C retires. Revaluation results in a profit of ₹30,000 and accumulated reserve is ₹12,000. C's total share from these two items is:",
                    options = listOf(
                        "₹5,000",
                        "₹7,000",
                        "₹8,000",
                        "₹10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0088",
                    question = "If a partner dies during the year, his share of profit up to the date of death is credited to his:",
                    options = listOf(
                        "Capital account",
                        "Drawings account",
                        "Loan account only",
                        "Revaluation account"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0089",
                    question = "On death of a partner, his share of goodwill is credited to his capital account and debited to:",
                    options = listOf(
                        "All remaining partners equally",
                        "Gaining partners in gaining ratio",
                        "Sacrificing partners in sacrificing ratio",
                        "Creditors"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_3_m0090",
                    question = "A, B and C share profits 3:2:1. C dies. His capital is ₹70,000, share of goodwill is ₹20,000, share of reserve is ₹5,000 and profit up to death is ₹10,000. Ignoring other adjustments, amount due to C's executor is:",
                    options = listOf(
                        "₹85,000",
                        "₹95,000",
                        "₹1,00,000",
                        "₹1,05,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_3",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0091",
                    question = "Dissolution of a firm means:",
                    options = listOf(
                        "Change in profit-sharing ratio",
                        "Admission of a partner",
                        "Closure of the firm's business and settlement of accounts",
                        "Retirement of a partner"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0092",
                    question = "Machinery having a book value of ₹80,000 is sold for ₹70,000. The effect on Realisation Account is:",
                    options = listOf(
                        "Profit ₹10,000",
                        "Loss ₹10,000",
                        "Profit ₹70,000",
                        "No effect"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0093",
                    question = "A and B share profits equally. Assets transferred to Realisation Account are ₹1,20,000 and external liabilities transferred are ₹50,000. Assets realise ₹1,00,000 and liabilities are settled for ₹45,000. Realisation expenses are ₹5,000. Realisation profit/loss is:",
                    options = listOf(
                        "Profit ₹20,000",
                        "Profit ₹10,000",
                        "Loss ₹10,000",
                        "Loss ₹20,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0094",
                    question = "On dissolution, which account is prepared to record the sale of assets and settlement of liabilities?",
                    options = listOf(
                        "Capital Account",
                        "Revaluation Account",
                        "Realisation Account",
                        "Trading Account"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0095",
                    question = "Debtors of ₹60,000 are realised at ₹54,000. The loss on realisation is:",
                    options = listOf(
                        "₹4,000",
                        "₹5,000",
                        "₹6,000",
                        "₹10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0096",
                    question = "An asset with book value ₹50,000 is taken over by Partner A at ₹45,000. The Realisation Account will show:",
                    options = listOf(
                        "Debit ₹50,000 and credit ₹45,000",
                        "Debit ₹45,000 and credit ₹50,000",
                        "Only credit ₹45,000",
                        "No entry"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0097",
                    question = "On dissolution, assets are generally transferred to:",
                    options = listOf(
                        "Cash Account",
                        "Realisation Account",
                        "Capital Account",
                        "Bank Account"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0098",
                    question = "Creditors of ₹50,000 are settled for ₹47,000. The resulting gain is:",
                    options = listOf(
                        "₹2,000",
                        "₹3,000",
                        "₹5,000",
                        "₹47,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0099",
                    question = "A creditor of ₹40,000 takes over machinery valued at ₹35,000 in full settlement of his claim. The balance ₹5,000 is:",
                    options = listOf(
                        "Paid by the creditor",
                        "Paid by the firm",
                        "Transferred to partners' capital accounts",
                        "Ignored"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0100",
                    question = "External liabilities are transferred to Realisation Account at:",
                    options = listOf(
                        "Book value",
                        "Market value",
                        "Realisable value",
                        "Nil value"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0101",
                    question = "If a partner takes over an asset at ₹40,000, the partner's capital account is:",
                    options = listOf(
                        "Debited ₹40,000",
                        "Credited ₹40,000",
                        "Debited ₹20,000",
                        "Not affected"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0102",
                    question = "An unrecorded asset is sold for ₹12,000 and an unrecorded liability of ₹7,000 is paid. The net effect on Realisation Account is:",
                    options = listOf(
                        "Profit ₹5,000",
                        "Loss ₹5,000",
                        "Profit ₹19,000",
                        "Loss ₹19,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0103",
                    question = "An unrecorded asset realised for cash on dissolution is credited to:",
                    options = listOf(
                        "Partner's Capital Account",
                        "Cash/Bank Account",
                        "Realisation Account",
                        "Goodwill Account"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0104",
                    question = "If a partner takes over a liability of ₹15,000, his capital account is:",
                    options = listOf(
                        "Debited ₹15,000",
                        "Credited ₹15,000",
                        "Credited ₹30,000",
                        "Not affected"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0105",
                    question = "Realisation Account shows total credits of ₹1,50,000 and total debits of ₹1,65,000 before transfer to partners. The result is:",
                    options = listOf(
                        "Realisation profit ₹15,000",
                        "Realisation loss ₹15,000",
                        "Realisation profit ₹3,15,000",
                        "No profit/loss"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0106",
                    question = "An unrecorded liability paid on dissolution is debited to:",
                    options = listOf(
                        "Realisation Account",
                        "Cash Account",
                        "Capital Account",
                        "Bank Loan Account"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0107",
                    question = "If a firm's asset is taken over by a partner at ₹25,000, the Realisation Account is:",
                    options = listOf(
                        "Debited ₹25,000",
                        "Credited ₹25,000",
                        "Not affected",
                        "Debited ₹50,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0108",
                    question = "A and B share profits 3:2. On dissolution, Realisation Account shows a loss of ₹25,000. A's share of the loss is:",
                    options = listOf(
                        "₹10,000",
                        "₹12,000",
                        "₹15,000",
                        "₹20,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0109",
                    question = "Realisation profit or loss is transferred to partners' capital accounts in their:",
                    options = listOf(
                        "New ratio",
                        "Gaining ratio",
                        "Old profit-sharing ratio",
                        "Capital ratio"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_4_m0110",
                    question = "If realisation expenses of ₹8,000 are paid by the firm, the entry includes:",
                    options = listOf(
                        "Realisation A/c Dr. ₹8,000",
                        "Cash A/c Dr. ₹8,000",
                        "Capital A/c Dr. ₹8,000",
                        "Realisation A/c Cr. ₹8,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_4",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0111",
                    question = "Share capital represents:",
                    options = listOf(
                        "Loan taken by the company",
                        "Capital raised by issuing shares",
                        "Profit earned by the company",
                        "Trade payable"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0112",
                    question = "A company issues a ₹10 share at ₹12. The securities premium per share is:",
                    options = listOf(
                        "₹1",
                        "₹2",
                        "₹10",
                        "₹12"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0113",
                    question = "A company issues 20,000 shares of ₹10 each at ₹12. The shares are payable ₹3 on application, ₹5 on allotment including premium, and balance on first and final call. Securities premium included in allotment is:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹60,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0114",
                    question = "A company can issue shares:",
                    options = listOf(
                        "Only for cash",
                        "Only at par",
                        "At par, premium or discount subject to applicable law",
                        "Only at premium"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0115",
                    question = "A company issues 10,000 shares of ₹10 each at par. Total share capital raised is:",
                    options = listOf(
                        "₹10,000",
                        "₹50,000",
                        "₹1,00,000",
                        "₹1,20,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0116",
                    question = "A shareholder holds 2,000 shares of ₹10 each. ₹7 per share has been called and he has paid ₹5 per share. The amount of calls in arrears is:",
                    options = listOf(
                        "₹2,000",
                        "₹3,000",
                        "₹4,000",
                        "₹5,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0117",
                    question = "The nominal value of a share is also called its:",
                    options = listOf(
                        "Market value",
                        "Face value",
                        "Book value",
                        "Realisable value"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0118",
                    question = "A company issues 5,000 shares of ₹10 each at ₹14. The total securities premium is:",
                    options = listOf(
                        "₹10,000",
                        "₹20,000",
                        "₹50,000",
                        "₹70,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0119",
                    question = "A company forfeits 1,000 shares of ₹10 each on which ₹7 per share had been received. The amount credited to Share Forfeiture Account is:",
                    options = listOf(
                        "₹3,000",
                        "₹5,000",
                        "₹7,000",
                        "₹10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0120",
                    question = "When shares are issued at a price equal to their face value, they are issued:",
                    options = listOf(
                        "At premium",
                        "At discount",
                        "At par",
                        "At loss"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0121",
                    question = "If ₹8 per share has been called on a ₹10 share and a shareholder has paid only ₹6, calls in arrears per share are:",
                    options = listOf(
                        "₹1",
                        "₹2",
                        "₹4",
                        "₹6"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0122",
                    question = "1,000 forfeited shares of ₹10 each, ₹7 called and ₹5 received, are reissued at ₹8 fully paid. The discount on reissue is:",
                    options = listOf(
                        "₹1,000",
                        "₹2,000",
                        "₹3,000",
                        "₹5,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0123",
                    question = "The excess of issue price over face value is called:",
                    options = listOf(
                        "Capital reserve",
                        "Securities premium",
                        "General reserve",
                        "Share forfeiture"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0124",
                    question = "A company receives ₹3 per share as application money on 20,000 shares. Application money received is:",
                    options = listOf(
                        "₹30,000",
                        "₹40,000",
                        "₹60,000",
                        "₹80,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0125",
                    question = "In Q24, the amount transferred to Capital Reserve after reissue, ignoring other costs, is:",
                    options = listOf(
                        "₹1,000",
                        "₹2,000",
                        "₹3,000",
                        "₹5,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0126",
                    question = "Application money is received when an investor:",
                    options = listOf(
                        "Applies for shares",
                        "Receives dividend",
                        "Transfers shares",
                        "Forfeits shares"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0127",
                    question = "If shares of ₹10 are issued at ₹13, the amount credited to Securities Premium Account per share is:",
                    options = listOf(
                        "₹3",
                        "₹10",
                        "₹13",
                        "₹23"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0128",
                    question = "A company issues 10,000 shares of ₹10 each at ₹12. Application ₹3, allotment ₹5 including premium and balance on final call. If one shareholder holding 500 shares fails to pay the final call of ₹4 per share, calls in arrears will be:",
                    options = listOf(
                        "₹1,000",
                        "₹1,500",
                        "₹2,000",
                        "₹2,500"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0129",
                    question = "Calls in arrears represent:",
                    options = listOf(
                        "Amount received in advance",
                        "Amount not received from shareholders when due",
                        "Profit on shares",
                        "Securities premium"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0130",
                    question = "On forfeiture of a share, the amount already received from the shareholder is generally credited to:",
                    options = listOf(
                        "Share Forfeiture Account",
                        "Securities Premium Account",
                        "Calls in Arrears Account",
                        "Capital Reserve directly"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0131",
                    question = "A company receives ₹5 per share in advance on 2,000 shares for a call that has not yet been made. The amount is treated as:",
                    options = listOf(
                        "Share capital immediately",
                        "Calls in advance",
                        "Securities premium",
                        "Share forfeiture"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0132",
                    question = "Calls in advance represent:",
                    options = listOf(
                        "Amount received before it is called",
                        "Unpaid share capital",
                        "Forfeited shares",
                        "Share premium"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0133",
                    question = "When forfeited shares are reissued at a discount, the discount allowed cannot generally exceed:",
                    options = listOf(
                        "Face value",
                        "Amount originally received on those shares",
                        "Amount forfeited on those shares",
                        "Securities premium"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0134",
                    question = "A company forfeits 500 shares of ₹10 each. ₹8 per share had been called and ₹6 per share had been received. If these shares are reissued at ₹9 fully paid, the maximum amount that can be transferred to Capital Reserve from these shares is:",
                    options = listOf(
                        "₹500",
                        "₹1,000",
                        "₹1,500",
                        "₹3,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0135",
                    question = "Forfeiture of shares generally occurs when a shareholder fails to pay:",
                    options = listOf(
                        "Dividend",
                        "Amount due on shares",
                        "Interest on capital",
                        "Tax"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0136",
                    question = "A shareholder holding 1,000 shares fails to pay ₹2 per share on a call. Calls in arrears are:",
                    options = listOf(
                        "₹500",
                        "₹1,000",
                        "₹2,000",
                        "₹10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0137",
                    question = "A company issues 15,000 shares of ₹10 each at ₹2 premium. If application money is ₹4 per share, the total application money received is:",
                    options = listOf(
                        "₹45,000",
                        "₹60,000",
                        "₹90,000",
                        "₹1,80,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0138",
                    question = "Shares forfeited may be reissued by the company:",
                    options = listOf(
                        "Never",
                        "Subject to applicable rules",
                        "Only at face value",
                        "Only to the original shareholder"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0139",
                    question = "If a company receives ₹4 per share as application money on 15,000 shares, the amount received is:",
                    options = listOf(
                        "₹45,000",
                        "₹60,000",
                        "₹75,000",
                        "₹1,50,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_5_m0140",
                    question = "A company forfeits 2,000 shares of ₹10 each. ₹8 per share was called and ₹6 per share was received. If the shares are reissued at ₹9 fully paid, the balance remaining in Share Forfeiture Account after reissue is:",
                    options = listOf(
                        "₹2,000",
                        "₹4,000",
                        "₹6,000",
                        "₹12,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_5",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0141",
                    question = "A debenture represents:",
                    options = listOf(
                        "Ownership capital",
                        "Borrowed capital of a company",
                        "Reserve capital",
                        "Share premium"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0142",
                    question = "A company issues 1,000 debentures of ₹100 each at par. Amount raised is:",
                    options = listOf(
                        "₹10,000",
                        "₹50,000",
                        "₹1,00,000",
                        "₹1,10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0143",
                    question = "A company issues 2,000 ₹100 debentures at 5% premium. The total amount received is:",
                    options = listOf(
                        "₹1,90,000",
                        "₹2,00,000",
                        "₹2,10,000",
                        "₹2,20,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0144",
                    question = "A debenture holder is a:",
                    options = listOf(
                        "Owner of the company",
                        "Creditor of the company",
                        "Promoter of the company",
                        "Director of the company"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0145",
                    question = "A ₹1,000 debenture is issued at 5% premium. Issue price is:",
                    options = listOf(
                        "₹950",
                        "₹1,000",
                        "₹1,050",
                        "₹1,500"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0146",
                    question = "₹3,00,000 debentures are issued at 4% discount and redeemable at 6% premium. Total loss on issue of debentures is:",
                    options = listOf(
                        "₹12,000",
                        "₹18,000",
                        "₹30,000",
                        "₹6,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0147",
                    question = "Interest on debentures is generally:",
                    options = listOf(
                        "Appropriation of profit",
                        "Charge against profit",
                        "Distribution of reserve",
                        "Capital expenditure"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0148",
                    question = "A company issues ₹2,00,000 of 10% debentures. Annual interest is:",
                    options = listOf(
                        "₹10,000",
                        "₹15,000",
                        "₹20,000",
                        "₹25,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0149",
                    question = "A company issues ₹5,00,000 10% debentures at 3% premium. Annual interest and amount of premium received are respectively:",
                    options = listOf(
                        "₹50,000 and ₹15,000",
                        "₹15,000 and ₹50,000",
                        "₹50,000 and ₹5,000",
                        "₹35,000 and ₹15,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0150",
                    question = "Debentures may be issued:",
                    options = listOf(
                        "At par only",
                        "At premium only",
                        "At discount only",
                        "At par, premium or discount, subject to applicable law"
                    ),
                    correctAnswer = 3,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0151",
                    question = "₹5,00,000, 8% debentures are issued. Annual debenture interest is:",
                    options = listOf(
                        "₹20,000",
                        "₹30,000",
                        "₹40,000",
                        "₹50,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0152",
                    question = "A company issues ₹4,00,000 debentures at 5% discount, redeemable at 10% premium. The total loss on issue is:",
                    options = listOf(
                        "₹20,000",
                        "₹40,000",
                        "₹60,000",
                        "₹80,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0153",
                    question = "The amount above the face value of a debenture is called:",
                    options = listOf(
                        "Capital reserve",
                        "Securities premium",
                        "General reserve",
                        "Debenture reserve"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0154",
                    question = "If ₹1,00,000 debentures are issued at 4% discount, cash received is:",
                    options = listOf(
                        "₹96,000",
                        "₹1,04,000",
                        "₹1,00,000",
                        "₹90,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0155",
                    question = "₹2,00,000 12% debentures are issued at 5% premium and redeemable at 10% premium. The total amount payable on redemption is:",
                    options = listOf(
                        "₹2,00,000",
                        "₹2,10,000",
                        "₹2,20,000",
                        "₹2,30,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0156",
                    question = "Debentures issued as security for a loan are called:",
                    options = listOf(
                        "Convertible debentures",
                        "Collateral security",
                        "Redeemable shares",
                        "Bonus debentures"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0157",
                    question = "If ₹2,00,000 debentures are redeemable at 5% premium, the amount payable on redemption is:",
                    options = listOf(
                        "₹1,90,000",
                        "₹2,00,000",
                        "₹2,05,000",
                        "₹2,10,000"
                    ),
                    correctAnswer = 3,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0158",
                    question = "A company issues ₹6,00,000 debentures at 4% discount. If the debentures are redeemable at par, the amount of loss on issue is:",
                    options = listOf(
                        "₹12,000",
                        "₹24,000",
                        "₹30,000",
                        "₹36,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0159",
                    question = "Debenture interest is calculated on:",
                    options = listOf(
                        "Market value",
                        "Face value of debentures",
                        "Book value of assets",
                        "Net profit"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0160",
                    question = "When debentures are issued at discount and redeemable at premium, the company incurs:",
                    options = listOf(
                        "Only discount",
                        "Only premium",
                        "Both discount and premium",
                        "Neither"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0161",
                    question = "A company issues ₹3,00,000 8% debentures at 6% premium. If interest is paid half-yearly, each instalment of interest will be:",
                    options = listOf(
                        "₹12,000",
                        "₹18,000",
                        "₹24,000",
                        "₹9,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0162",
                    question = "Redemption of debentures means:",
                    options = listOf(
                        "Issue of shares",
                        "Repayment of debenture liability",
                        "Payment of dividend",
                        "Creation of goodwill"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0163",
                    question = "If debenture interest is payable half-yearly, the interest on ₹4,00,000 12% debentures for one half-year is:",
                    options = listOf(
                        "₹12,000",
                        "₹24,000",
                        "₹48,000",
                        "₹6,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_6_m0164",
                    question = "₹5,00,000 debentures are issued at 4% discount and redeemable at 8% premium. The total amount received on issue and amount payable on redemption are respectively:",
                    options = listOf(
                        "₹4,80,000 and ₹5,40,000",
                        "₹5,20,000 and ₹5,40,000",
                        "₹4,80,000 and ₹5,00,000",
                        "₹5,00,000 and ₹5,40,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_6",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0165",
                    question = "Financial statements are prepared mainly to:",
                    options = listOf(
                        "Record daily transactions",
                        "Show the financial performance and position of a company",
                        "Calculate only cash balance",
                        "Determine partners' profit"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0166",
                    question = "Which of the following is a non-current asset?",
                    options = listOf(
                        "Inventory",
                        "Trade receivables",
                        "Plant and machinery",
                        "Cash"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0167",
                    question = "A company has current assets of ₹4,00,000 and current liabilities of ₹2,50,000. Its working capital is:",
                    options = listOf(
                        "₹1,00,000",
                        "₹1,50,000",
                        "₹2,50,000",
                        "₹6,50,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0168",
                    question = "The Balance Sheet shows the:",
                    options = listOf(
                        "Financial position of the company",
                        "Daily sales",
                        "Cash receipts only",
                        "Gross profit only"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0169",
                    question = "Which of the following is generally a current liability?",
                    options = listOf(
                        "Equity share capital",
                        "Trade payables",
                        "Goodwill",
                        "Land"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0170",
                    question = "Revenue from operations is ₹8,00,000, cost of goods sold is ₹5,00,000 and operating expenses are ₹1,20,000. Operating profit before other adjustments is:",
                    options = listOf(
                        "₹1,20,000",
                        "₹1,80,000",
                        "₹2,00,000",
                        "₹3,00,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0171",
                    question = "The Statement of Profit and Loss shows:",
                    options = listOf(
                        "Assets only",
                        "Liabilities only",
                        "Income and expenses of the company",
                        "Shareholders' names"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0172",
                    question = "Revenue from operations for a manufacturing company mainly includes:",
                    options = listOf(
                        "Sale of goods",
                        "Issue of shares",
                        "Bank loan",
                        "Sale of investments only"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0173",
                    question = "A company has trade receivables ₹2,00,000 and provision for doubtful debts ₹10,000. The net amount of trade receivables shown will be:",
                    options = listOf(
                        "₹2,10,000",
                        "₹2,00,000",
                        "₹1,90,000",
                        "₹10,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0174",
                    question = "Assets are generally shown on the:",
                    options = listOf(
                        "Liabilities side only",
                        "Assets side of the Balance Sheet",
                        "Profit and Loss Statement only",
                        "Cash Book"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0175",
                    question = "Depreciation is treated as:",
                    options = listOf(
                        "Income",
                        "Expense",
                        "Liability",
                        "Capital receipt"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0176",
                    question = "Current assets are ₹6,00,000 and current liabilities are ₹3,00,000. If ₹50,000 of trade payables are paid, the new current ratio will be:",
                    options = listOf(
                        "1.5:1",
                        "2:1",
                        "2.2:1",
                        "2.5:1"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0177",
                    question = "Trade receivables represent:",
                    options = listOf(
                        "Amount payable to suppliers",
                        "Amount receivable from customers",
                        "Bank loan",
                        "Share capital"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0178",
                    question = "Outstanding expenses are:",
                    options = listOf(
                        "Assets",
                        "Liabilities",
                        "Income",
                        "Drawings"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0179",
                    question = "A company purchases machinery for ₹5,00,000 and pays ₹50,000 for installation. The amount initially recognised as machinery will be:",
                    options = listOf(
                        "₹4,50,000",
                        "₹5,00,000",
                        "₹5,50,000",
                        "₹50,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0180",
                    question = "Trade payables are:",
                    options = listOf(
                        "Amount due to suppliers",
                        "Amount due from customers",
                        "Cash in hand",
                        "Investments"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0181",
                    question = "Prepaid expenses are classified as:",
                    options = listOf(
                        "Current assets",
                        "Current liabilities",
                        "Equity",
                        "Revenue"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0182",
                    question = "A company has profit before tax of ₹2,50,000 and tax expense of ₹70,000. Profit after tax is:",
                    options = listOf(
                        "₹1,80,000",
                        "₹2,00,000",
                        "₹3,20,000",
                        "₹70,000"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0183",
                    question = "Share capital is shown under:",
                    options = listOf(
                        "Current assets",
                        "Shareholders' funds/equity",
                        "Current liabilities",
                        "Revenue from operations"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0184",
                    question = "A provision for doubtful debts is created mainly to:",
                    options = listOf(
                        "Increase sales",
                        "Recognise possible loss from doubtful receivables",
                        "Increase share capital",
                        "Reduce liabilities"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0185",
                    question = "If current assets increase by ₹40,000 while current liabilities remain unchanged at ₹2,00,000, and existing current assets were ₹4,00,000, the current ratio becomes:",
                    options = listOf(
                        "2:1",
                        "2.1:1",
                        "2.2:1",
                        "2.4:1"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0186",
                    question = "Inventories are classified as:",
                    options = listOf(
                        "Current assets",
                        "Non-current liabilities",
                        "Shareholders' funds",
                        "Revenue"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0187",
                    question = "Which item is normally shown under Other Current Assets?",
                    options = listOf(
                        "Short-term loans and advances",
                        "Equity share capital",
                        "Long-term borrowings",
                        "Debentures"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_7_m0188",
                    question = "A company's total assets are ₹15,00,000 and total liabilities excluding shareholders' funds are ₹6,00,000. Shareholders' funds will be:",
                    options = listOf(
                        "₹6,00,000",
                        "₹9,00,000",
                        "₹15,00,000",
                        "₹21,00,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_7",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0189",
                    question = "Accounting ratios are mainly used to:",
                    options = listOf(
                        "Record journal entries",
                        "Analyse financial performance and position",
                        "Prepare cash book",
                        "Calculate share capital only"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0190",
                    question = "Current assets are ₹3,00,000 and current liabilities are ₹1,50,000. Current Ratio is:",
                    options = listOf(
                        "1:1",
                        "1.5:1",
                        "2:1",
                        "3:1"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0191",
                    question = "A company's current ratio is 2:1. Current liabilities are ₹2,00,000. Current assets are:",
                    options = listOf(
                        "₹1,00,000",
                        "₹2,00,000",
                        "₹4,00,000",
                        "₹6,00,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0192",
                    question = "Current Ratio is calculated as:",
                    options = listOf(
                        "Current Assets ÷ Current Liabilities",
                        "Current Liabilities ÷ Current Assets",
                        "Liquid Assets ÷ Current Liabilities",
                        "Sales ÷ Current Assets"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0193",
                    question = "Quick assets are ₹1,80,000 and current liabilities are ₹1,20,000. Quick Ratio is:",
                    options = listOf(
                        "1:1",
                        "1.5:1",
                        "2:1",
                        "2.5:1"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0194",
                    question = "Current assets are ₹5,00,000, including inventory ₹1,50,000 and prepaid expenses ₹50,000. Current liabilities are ₹2,00,000. Quick Ratio is:",
                    options = listOf(
                        "1:1",
                        "1.25:1",
                        "1.5:1",
                        "2.5:1"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0195",
                    question = "Quick Ratio is also known as:",
                    options = listOf(
                        "Current Ratio",
                        "Acid-Test Ratio",
                        "Debt Ratio",
                        "Gross Profit Ratio"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0196",
                    question = "Revenue from Operations is ₹8,00,000 and Gross Profit is ₹2,00,000. Gross Profit Ratio is:",
                    options = listOf(
                        "20%",
                        "25%",
                        "30%",
                        "40%"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0197",
                    question = "Revenue from Operations is ₹10,00,000, Gross Profit is ₹3,00,000 and operating expenses are ₹1,20,000. Operating Profit Ratio is:",
                    options = listOf(
                        "12%",
                        "18%",
                        "20%",
                        "30%"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0198",
                    question = "Gross Profit Ratio is calculated on:",
                    options = listOf(
                        "Cost of Revenue from Operations",
                        "Revenue from Operations",
                        "Total Assets",
                        "Capital Employed"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0199",
                    question = "Cost of Revenue from Operations is ₹6,00,000 and Gross Profit is ₹1,50,000. Revenue from Operations is:",
                    options = listOf(
                        "₹4,50,000",
                        "₹6,50,000",
                        "₹7,50,000",
                        "₹9,00,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0200",
                    question = "A company's Debt-Equity Ratio is 1.5:1 and shareholders' funds are ₹6,00,000. Long-term debt is:",
                    options = listOf(
                        "₹3,00,000",
                        "₹6,00,000",
                        "₹9,00,000",
                        "₹12,00,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0201",
                    question = "Debt-Equity Ratio compares:",
                    options = listOf(
                        "Current assets and current liabilities",
                        "Debt and shareholders' funds",
                        "Sales and profit",
                        "Gross profit and net profit"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0202",
                    question = "Shareholders' funds are ₹5,00,000 and long-term debt is ₹2,50,000. Debt-Equity Ratio is:",
                    options = listOf(
                        "0.5:1",
                        "1:1",
                        "2:1",
                        "2.5:1"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0203",
                    question = "Cost of Revenue from Operations is ₹6,00,000 and Inventory Turnover Ratio is 5 times. Average inventory is:",
                    options = listOf(
                        "₹1,00,000",
                        "₹1,20,000",
                        "₹1,50,000",
                        "₹2,00,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0204",
                    question = "Inventory Turnover Ratio measures:",
                    options = listOf(
                        "Liquidity of creditors",
                        "Efficiency of inventory management",
                        "Profitability of shareholders",
                        "Long-term solvency only"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0205",
                    question = "Cost of Revenue from Operations is ₹4,00,000 and average inventory is ₹1,00,000. Inventory Turnover Ratio is:",
                    options = listOf(
                        "2 times",
                        "3 times",
                        "4 times",
                        "5 times"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0206",
                    question = "Net Profit after Tax is ₹1,20,000. Capital employed is ₹8,00,000. Return on Capital Employed is:",
                    options = listOf(
                        "10%",
                        "12%",
                        "15%",
                        "20%"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0207",
                    question = "Return on Investment is generally related to:",
                    options = listOf(
                        "Profitability",
                        "Liquidity",
                        "Inventory only",
                        "Trade receivables only"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_8_m0208",
                    question = "Net Profit after Tax is ₹80,000 and Revenue from Operations is ₹4,00,000. Net Profit Ratio is:",
                    options = listOf(
                        "10%",
                        "15%",
                        "20%",
                        "25%"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_8",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0209",
                    question = "Cash Flow Statement mainly shows:",
                    options = listOf(
                        "Profit earned during the year",
                        "Changes in cash and cash equivalents",
                        "Changes in share capital only",
                        "Total assets of the company"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0210",
                    question = "Dividend paid by a company is generally classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Non-cash activity"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0211",
                    question = "Net profit before tax is ₹2,00,000. Depreciation is ₹30,000 and gain on sale of machinery is ₹10,000. Ignoring working-capital changes, cash from operating activities before tax is:",
                    options = listOf(
                        "₹1,60,000",
                        "₹2,20,000",
                        "₹2,30,000",
                        "₹2,40,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0212",
                    question = "Cash flows are classified into how many main activities?",
                    options = listOf(
                        "Two",
                        "Three",
                        "Four",
                        "Five"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0213",
                    question = "Interest received by a non-financial company is generally classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Cash equivalent"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0214",
                    question = "Trade receivables increased by ₹20,000 and trade payables increased by ₹15,000. Ignoring other adjustments, the combined effect on cash from operating activities is:",
                    options = listOf(
                        "Increase ₹35,000",
                        "Decrease ₹35,000",
                        "Decrease ₹5,000",
                        "Increase ₹5,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0215",
                    question = "The three activities are:",
                    options = listOf(
                        "Operating, Investing and Financing",
                        "Trading, Profit and Loss and Balance Sheet",
                        "Current, Fixed and Intangible",
                        "Capital, Revenue and Deferred"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0216",
                    question = "Interest paid by a non-financial company is generally classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Non-cash activity"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0217",
                    question = "A company purchased machinery for ₹4,00,000 and sold another machine for ₹1,00,000. The net cash flow from these investing transactions is:",
                    options = listOf(
                        "Inflow ₹5,00,000",
                        "Outflow ₹3,00,000",
                        "Inflow ₹3,00,000",
                        "Outflow ₹5,00,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0218",
                    question = "Cash received from customers is generally classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Non-cash activity"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0219",
                    question = "Sale of machinery for cash is classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Current liability"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0220",
                    question = "A company issues shares for ₹5,00,000 and redeems debentures for ₹2,00,000. Ignoring other financing items, net cash flow from financing activities is:",
                    options = listOf(
                        "₹3,00,000 inflow",
                        "₹7,00,000 inflow",
                        "₹3,00,000 outflow",
                        "₹7,00,000 outflow"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0221",
                    question = "Purchase of machinery for cash is a:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Non-cash transaction"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0222",
                    question = "Cash received from issue of debentures is:",
                    options = listOf(
                        "Operating inflow",
                        "Investing inflow",
                        "Financing inflow",
                        "Non-cash inflow"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0223",
                    question = "Profit before tax is ₹3,00,000. Depreciation ₹40,000, increase in inventory ₹25,000 and increase in trade payables ₹15,000. Ignoring other adjustments, cash generated from operations before tax is:",
                    options = listOf(
                        "₹2,50,000",
                        "₹2,90,000",
                        "₹3,30,000",
                        "₹3,80,000"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0224",
                    question = "Issue of equity shares for cash is a:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Non-cash activity"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0225",
                    question = "Cash paid for purchase of investments is generally:",
                    options = listOf(
                        "Operating outflow",
                        "Investing outflow",
                        "Financing outflow",
                        "Non-cash transaction"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0226",
                    question = "A company has opening cash ₹80,000. During the year, operating activities generate ₹1,20,000, investing activities use ₹70,000 and financing activities generate ₹30,000. Closing cash balance is:",
                    options = listOf(
                        "₹1,20,000",
                        "₹1,40,000",
                        "₹1,60,000",
                        "₹2,00,000"
                    ),
                    correctAnswer = 2,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0227",
                    question = "Cash and cash equivalents generally include:",
                    options = listOf(
                        "Long-term investments only",
                        "Cash, bank balances and highly liquid short-term investments",
                        "Inventory",
                        "Trade receivables"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0228",
                    question = "Under the indirect method, depreciation is:",
                    options = listOf(
                        "Deducted from net profit",
                        "Added back to net profit",
                        "Treated as financing inflow",
                        "Treated as investing outflow"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0229",
                    question = "A machine with book value ₹60,000 is sold for ₹50,000. In the indirect method, the ₹10,000 loss on sale is:",
                    options = listOf(
                        "Added to net profit",
                        "Deducted from net profit",
                        "Shown as financing outflow",
                        "Ignored completely"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0230",
                    question = "Payment to suppliers for goods is generally classified as:",
                    options = listOf(
                        "Operating activity",
                        "Investing activity",
                        "Financing activity",
                        "Extraordinary activity"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.EASY,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0231",
                    question = "An increase in trade receivables, while calculating cash flow from operating activities using the indirect method, is:",
                    options = listOf(
                        "Added to profit",
                        "Deducted from profit",
                        "Ignored",
                        "Treated as financing inflow"
                    ),
                    correctAnswer = 1,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.MEDIUM,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        add(Question(
                    id = "accountancy_class_12_9_m0232",
                    question = "A company receives ₹2,00,000 as dividend from an investment and pays ₹80,000 for purchase of machinery. Under the stated non-financial-company classification, the net investing cash flow is:",
                    options = listOf(
                        "₹1,20,000 inflow",
                        "₹1,20,000 outflow",
                        "₹2,80,000 inflow",
                        "₹80,000 inflow"
                    ),
                    correctAnswer = 0,
                    explanation = "Correct option from the supplied MCQ source.",
                    subjectId = "accountancy",
                    chapterId = "accountancy_class_12_9",
                    board = Board.MP_BOARD,
                    classLevel = ClassLevel.CLASS_12,
                    difficulty = QuestionDifficulty.HARD,
                    tags = listOf("class12", "mp_board", "master_mcq")
                ))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_1", "Business Studies Chapter 1", BUSINESS_STUDIES_SEEDS["1"]!!, 30, "chapter", "business_studies_class_12_1_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_2", "Business Studies Chapter 2", BUSINESS_STUDIES_SEEDS["2"]!!, 30, "chapter", "business_studies_class_12_2_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_3", "Business Studies Chapter 3", BUSINESS_STUDIES_SEEDS["3"]!!, 30, "chapter", "business_studies_class_12_3_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_4", "Business Studies Chapter 4", BUSINESS_STUDIES_SEEDS["4"]!!, 30, "chapter", "business_studies_class_12_4_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_5", "Business Studies Chapter 5", BUSINESS_STUDIES_SEEDS["5"]!!, 30, "chapter", "business_studies_class_12_5_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_6", "Business Studies Chapter 6", BUSINESS_STUDIES_SEEDS["6"]!!, 30, "chapter", "business_studies_class_12_6_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_7", "Business Studies Chapter 7", BUSINESS_STUDIES_SEEDS["7"]!!, 30, "chapter", "business_studies_class_12_7_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_8", "Business Studies Chapter 8", BUSINESS_STUDIES_SEEDS["8"]!!, 30, "chapter", "business_studies_class_12_8_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_9", "Business Studies Chapter 9", BUSINESS_STUDIES_SEEDS["9"]!!, 30, "chapter", "business_studies_class_12_9_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_10", "Business Studies Chapter 10", BUSINESS_STUDIES_SEEDS["10"]!!, 30, "chapter", "business_studies_class_12_10_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_11", "Business Studies Chapter 11", BUSINESS_STUDIES_SEEDS["11"]!!, 30, "chapter", "business_studies_class_12_11_new"))
        addAll(makeGeneratedQuestions("business_studies", "business_studies_class_12_12", "Business Studies Chapter 12", BUSINESS_STUDIES_SEEDS["12"]!!, 30, "chapter", "business_studies_class_12_12_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_micro_1", "Economics micro chapter 1", ECONOMICS_SEEDS["micro_1"]!!, 30, "chapter", "economics_class_12_micro_1_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_micro_2", "Economics micro chapter 2", ECONOMICS_SEEDS["micro_2"]!!, 30, "chapter", "economics_class_12_micro_2_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_micro_3", "Economics micro chapter 3", ECONOMICS_SEEDS["micro_3"]!!, 30, "chapter", "economics_class_12_micro_3_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_micro_4", "Economics micro chapter 4", ECONOMICS_SEEDS["micro_4"]!!, 30, "chapter", "economics_class_12_micro_4_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_micro_5", "Economics micro chapter 5", ECONOMICS_SEEDS["micro_5"]!!, 30, "chapter", "economics_class_12_micro_5_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_1", "Economics macro chapter 1", ECONOMICS_SEEDS["macro_1"]!!, 30, "chapter", "economics_class_12_macro_1_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_2", "Economics macro chapter 2", ECONOMICS_SEEDS["macro_2"]!!, 30, "chapter", "economics_class_12_macro_2_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_3", "Economics macro chapter 3", ECONOMICS_SEEDS["macro_3"]!!, 30, "chapter", "economics_class_12_macro_3_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_4", "Economics macro chapter 4", ECONOMICS_SEEDS["macro_4"]!!, 30, "chapter", "economics_class_12_macro_4_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_5", "Economics macro chapter 5", ECONOMICS_SEEDS["macro_5"]!!, 30, "chapter", "economics_class_12_macro_5_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_macro_6", "Economics macro chapter 6", ECONOMICS_SEEDS["macro_6"]!!, 30, "chapter", "economics_class_12_macro_6_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_1", "Economics ied chapter 1", ECONOMICS_SEEDS["ied_1"]!!, 30, "chapter", "economics_class_12_ied_1_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_2", "Economics ied chapter 2", ECONOMICS_SEEDS["ied_2"]!!, 30, "chapter", "economics_class_12_ied_2_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_3", "Economics ied chapter 3", ECONOMICS_SEEDS["ied_3"]!!, 30, "chapter", "economics_class_12_ied_3_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_4", "Economics ied chapter 4", ECONOMICS_SEEDS["ied_4"]!!, 30, "chapter", "economics_class_12_ied_4_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_5", "Economics ied chapter 5", ECONOMICS_SEEDS["ied_5"]!!, 30, "chapter", "economics_class_12_ied_5_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_6", "Economics ied chapter 6", ECONOMICS_SEEDS["ied_6"]!!, 30, "chapter", "economics_class_12_ied_6_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_7", "Economics ied chapter 7", ECONOMICS_SEEDS["ied_7"]!!, 30, "chapter", "economics_class_12_ied_7_new"))
        addAll(makeGeneratedQuestions("economics", "economics_class_12_ied_8", "Economics ied chapter 8", ECONOMICS_SEEDS["ied_8"]!!, 30, "chapter", "economics_class_12_ied_8_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_1", "Mathematics Chapter 1", MATHEMATICS_SEEDS["1"]!!, 30, "chapter", "mathematics_class_12_1_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_2", "Mathematics Chapter 2", MATHEMATICS_SEEDS["2"]!!, 30, "chapter", "mathematics_class_12_2_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_3", "Mathematics Chapter 3", MATHEMATICS_SEEDS["3"]!!, 30, "chapter", "mathematics_class_12_3_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_4", "Mathematics Chapter 4", MATHEMATICS_SEEDS["4"]!!, 30, "chapter", "mathematics_class_12_4_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_5", "Mathematics Chapter 5", MATHEMATICS_SEEDS["5"]!!, 30, "chapter", "mathematics_class_12_5_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_6", "Mathematics Chapter 6", MATHEMATICS_SEEDS["6"]!!, 30, "chapter", "mathematics_class_12_6_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_7", "Mathematics Chapter 7", MATHEMATICS_SEEDS["7"]!!, 30, "chapter", "mathematics_class_12_7_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_8", "Mathematics Chapter 8", MATHEMATICS_SEEDS["8"]!!, 30, "chapter", "mathematics_class_12_8_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_9", "Mathematics Chapter 9", MATHEMATICS_SEEDS["9"]!!, 30, "chapter", "mathematics_class_12_9_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_10", "Mathematics Chapter 10", MATHEMATICS_SEEDS["10"]!!, 30, "chapter", "mathematics_class_12_10_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_11", "Mathematics Chapter 11", MATHEMATICS_SEEDS["11"]!!, 30, "chapter", "mathematics_class_12_11_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_12", "Mathematics Chapter 12", MATHEMATICS_SEEDS["12"]!!, 30, "chapter", "mathematics_class_12_12_new"))
        addAll(makeGeneratedQuestions("mathematics", "mathematics_class_12_13", "Mathematics Chapter 13", MATHEMATICS_SEEDS["13"]!!, 30, "chapter", "mathematics_class_12_13_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_1", "Hindi Chapter 1", HINDI_SEEDS["1"]!!, 34, "chapter", "hindi_class_12_1_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_2", "Hindi Chapter 2", HINDI_SEEDS["2"]!!, 34, "chapter", "hindi_class_12_2_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_3", "Hindi Chapter 3", HINDI_SEEDS["3"]!!, 34, "chapter", "hindi_class_12_3_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_4", "Hindi Chapter 4", HINDI_SEEDS["4"]!!, 34, "chapter", "hindi_class_12_4_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_5", "Hindi Chapter 5", HINDI_SEEDS["5"]!!, 34, "chapter", "hindi_class_12_5_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_6", "Hindi Chapter 6", HINDI_SEEDS["6"]!!, 34, "chapter", "hindi_class_12_6_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_7", "Hindi Chapter 7", HINDI_SEEDS["7"]!!, 34, "chapter", "hindi_class_12_7_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_8", "Hindi Chapter 8", HINDI_SEEDS["8"]!!, 34, "chapter", "hindi_class_12_8_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_9", "Hindi Chapter 9", HINDI_SEEDS["9"]!!, 34, "chapter", "hindi_class_12_9_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_1", "English Chapter 1", ENGLISH_SEEDS["1"]!!, 35, "chapter", "english_class_12_1_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_2", "English Chapter 2", ENGLISH_SEEDS["2"]!!, 35, "chapter", "english_class_12_2_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_3", "English Chapter 3", ENGLISH_SEEDS["3"]!!, 35, "chapter", "english_class_12_3_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_4", "English Chapter 4", ENGLISH_SEEDS["4"]!!, 35, "chapter", "english_class_12_4_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_5", "English Chapter 5", ENGLISH_SEEDS["5"]!!, 35, "chapter", "english_class_12_5_new"))
        addAll(makeGeneratedQuestions("hindi", "hindi_class_12_grammar", "Hindi Grammar", HINDI_GRAMMAR_SEEDS, 30, "grammar", "hindi_grammar_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_grammar", "English Grammar", ENGLISH_GRAMMAR_SEEDS, 40, "grammar", "english_grammar_new"))
        addAll(makeGeneratedQuestions("english", "english_class_12_book", "English Book-Based", ENGLISH_BOOK_SEEDS, 80, "book", "english_book_new"))
    }
}
