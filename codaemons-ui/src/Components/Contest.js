import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { Controlled as CodeMirror } from 'react-codemirror2';
import ActivityIndicator from 'react-activity-indicator'
//import {ActivityIndicator} from 'react-native';
    /*import Pusher from 'pusher-js';
    import pushid from 'pushid';
    import axios from 'axios';*/

    import '../App.css';
    import 'codemirror/lib/codemirror.css';
    import 'codemirror/theme/dracula.css';

    import 'codemirror/mode/clike/clike.js';

    class Contest extends Component {
      constructor() {
        super();
        this.state = {
          id: '',
          java: 'public class Main{\n\t\tpublic static void main(String[] args){\n\t\t}\n}',
          result: '',
          qNo: '',
          question: '',
          loading: false,
          redirect: false
        };
      }

        processResponse(response) {
            console.log(response);
            const statusCode = response.status;
            const data = response.json();
            return Promise.all([statusCode, data]).then(res => ({
            statusCode: res[0],
            data: res[1]
            }));
        };

      componentDidMount() {
        
        const token = localStorage.getItem("token");
        const bearer = "Bearer " + token;
        const requestOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': bearer
            },
          };
        fetch('https://localhost:443/api/v1/validatetoken', requestOptions)
            .then(res => res.status)
            .then(res => {
                console.log(res);
                //const { statusCode } = res;
                if(res !== 200){
                    this.setState({redirect: true})
                }
            }
            );
        };
      

      /*componentDidUpdate() {
        this.runCode();
      }

      runCode = () => {
        const { java } = this.state;

        const iframe = this.refs.iframe;
        const document = iframe.contentDocument;
        const documentContents = `
          <!DOCTYPE html>
          <html lang="en">
          <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Document</title>
          </head>
          <body>
            ${java}

           
          </body>
          </html>
        `;

        document.open();
        document.write(documentContents);
        document.close();
      };*/

      submitCode = () => {
        this.setState({loading:true});
        const token = localStorage.getItem("token");
        const bearer = "Bearer " + token;
        const requestOptions = {
          method: 'POST',
          headers: { 
            'Content-Type': 'application/json',
            'Authorization': bearer 
          },
          body: JSON.stringify({
            "userId": "1",
            "languageId": "62",   
            "questionId": this.state.qNo, 
            "sourceCode": this.state.java
          })
        };
      fetch('https://localhost:443/api/v1/userSubmission/test', requestOptions)
          .then(response => response.text())
          .then(data => this.setState({ result: data, loading: false }));
      };

      fetchQuestion = () => {
        const token = localStorage.getItem("token");
        const bearer = "Bearer " + token;
        const requestOptions = {
          method: 'GET',
          headers: { 'Authorization': bearer },
        };
      fetch('https://localhost:443/api/v1/questions/'+this.state.qNo, requestOptions)
          .then(response => response.json())
          .then(data => this.setState({ question: data.questionDescription }));
      };

      render() {
        if(this.state.redirect){
            return <Redirect to='/login'/>;
        }
        const { java, result } = this.state;
        const codeMirrorOptions = {
          theme: 'dracula',
          lineNumbers: true,
          scrollbarStyle: null,
          lineWrapping: true,
        };

        return (
        <div>
                <textarea
                  value = {this.state.question}
                  placeholder="Question appears here!"
                  rows={10}
                  cols={100}
                />
                <textarea
                  value = {this.state.qNo}
                  placeholder="Enter question number"
                  onChange={(evt) => {
                    this.setState({qNo: evt.target.value});
                  }}
                />
                <button onClick={this.fetchQuestion}> Fetch Question </button>
                <CodeMirror
                  value={java}
                  options={{
                    mode: 'text/x-java',
                    ...codeMirrorOptions,
                  }}
                  onBeforeChange={(editor, data, java) => {
                    this.setState({ java: java });
                  }}
                />
                <button onClick={this.submitCode}> Submit </button>
                {this.state.loading ? <div style={{textAlign: 'center'}}><ActivityIndicator/></div> : <label>Your answer is: {this.state.result.toString()}</label>}
            </div>
        );
      }
    }

    export default Contest;