<html>
<head>
    <title></title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/json2html/1.2.0/json2html.min.js"></script>

    <script>
        var t = {'<>':'div','html':'${title} ${year}'};

        var d = [
            {"title":"Heat","year":"1995"},
            {"title":"Snatch","year":"2000"},
            {"title":"Up","year":"2009"},
            {"title":"Unforgiven","year":"1992"},
            {"title":"Amadeus","year":"1984"}
        ];

        document.write( json2html.transform(d,t) );
    </script>
</head>
<body >

</body>
</html>
