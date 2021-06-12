# TreasureHunt
Find the treasure by following hint. 
This is a REST application which provides api to send matrix data .
User will get path to the treasure in the response. 

# Service
HTTP POST service which excepts requset in json format.

##Sample request

{
    "matrix": [
        [
            {
                "row": 0,
                "col": 0,
                "value":34
            },
            {
                "row": 0,
                "col": 1,
                "value":31
            },
            {
                "row": 0,
                "col": 2,
                "value":32

            },
            {
                "row": 0,
                "col": 3,
                "value":41
            },
            {
                "row": 0,
                "col": 4,
                "value":25
            }
        ],
        [
            {
                "row": 1,
                "col": 0,
                "value":14
            },
            {
                "row": 1,
                "col": 1,
                "value":42
            },
            {
                "row": 1,
                "col": 2,
                "value":43
            },
            {
                "row": 1,
                "col": 3,
                "value":14
            },
            {
                "row": 1,
                "col": 4,
                "value":31
            }
        ],
        [
            {
                "row": 2,
                "col": 0,
                "value":54
            },
            {
                "row": 2,
                "col": 1,
                "value":45
            },
            {
                "row": 2,
                "col": 2,
                "value":52
            },
            {
                "row": 2,
                "col": 3,
                "value":42
            },
            {
                "row": 2,
                "col": 4,
                "value":23
            }
        ],
        [
            {
                "row": 3,
                "col": 0,
                "value":33
            },
            {
                "row": 3,
                "col": 1,
                "value":15
            },
            {
                "row": 3,
                "col": 2,
                "value":51
            },
            {
                "row": 3,
                "col": 3,
                "value":31
            },
            {
                "row": 3,
                "col": 4,
                "value":35
            }
        ],
        [
            {
                "row": 4,
                "col": 0,
                "value":21
            },
            {
                "row": 4,
                "col": 1,
                "value":52
            },
            {
                "row": 4,
                "col": 2,
                "value":33
            },
            {
                "row": 4,
                "col": 3,
                "value":13
            },
            {
                "row": 4,
                "col": 4,
                "value":16
            }
        ]
    ]
}
