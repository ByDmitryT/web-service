import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './component/App/App';
import {Provider} from 'react-redux'
import {createStore, combineReducers} from 'redux';
import reducer from './reducer'

const store = createStore(
    combineReducers({
        employees: reducer
    }),
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);
ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);
