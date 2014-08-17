$( document ).ready(function() {
    $('#keypad')
        .keyboard({
            layout : 'custom',
            customLayout : {
                'default': [
                    '1 2 3',
                    '4 5 6',
                    '7 8 9',
                    '0 {bksp}'
                ]},
            restrictInput : true, // Prevent keys not in the displayed keyboard from being typed in
            maxLength : 4,
            preventPaste : true,  // prevent ctrl-v and right click
            autoAccept : true,
            usePreview : false
        })
});