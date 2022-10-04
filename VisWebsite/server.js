const net = require('net');
const port = 5000;
const host = '127.0.0.1';




function Server() {

    const server = net.createServer();
    server.listen(port, host, () => {
        console.log(`TCP server is running on port ${port}.`);
    });
    
    let sockets = [];
    
    server.on('connect', function(sock) {
        let remoteAddress = sock.remoteAddress
        let remotePort = sock.remotePort;
        console.log(`CONNECTED + ${remoteAddress} : ${remotePort}`);
        sockets.push(sock);
    
        sock.on('data', function(data) {
            console.log(`DATA ${remoteAddress} : ${data}`);
            sockets.forEach(function(sock, index, array) {
                sock.write(`${remoteAddress} : ${remotePort} said ${data}\n`);
            });
        });
    
        sock.on('close', function(data) {
            let index = sockets.findIndex(function(o) {
                return o.remoteAddress === remoteAddress && 
                    o.remoteAddress === remotePort
            });
            if (index !== -1) { sockets.splice(index, 1); }
            console.log(`CLOSED ${remoteAddress} ${remotePort}`);
        });
    });
}

const client = new net.Socket();

let json = {
    "this is something" : "this is someting"
}


client.connect(port, host, function() {
    console.log("connected");
    // client.write('s');
    client.write(`Hello from Client ${client.address().address}`.toString());
});

client.on('data', function(data) {
    console.log(`Server says : ${data}`);
    let string = `Hello from Client ${client.address().address}`
    client.write(JSON.stringify(json));

});

client.on('close', function() {
    console.log('Connection closed');
});
