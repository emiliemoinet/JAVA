import styled from 'styled-components';

export const Submit = styled.button`
  font-family: 'Montserrat', sans-serif;
  margin: 5px;
  margin-top: 20px;
  font-size: 20px;
  background-color: #fff;
  border: solid #363636 1px;
  padding: 10px;
  border-radius: 30px;
  transition: all 0.3s;
  transform: scale(1);

  :hover {
    cursor: pointer;
    background-color: #363636;
    color: white;
  }

  :active {
    transform: scale(0.95);
  }

  :disabled {
    display: none;
  }
`;
