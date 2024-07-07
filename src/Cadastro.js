// src/Cadastro.js
import React, { useState } from 'react';
import 'antd/dist/reset.css';
import { Button, Checkbox, Form, Grid, Input, Modal, Typography, theme } from "antd";
import { LockOutlined, MailOutlined, UserOutlined, PaperClipOutlined } from "@ant-design/icons";
import logo from './images/LOGOV2-2.png';

import PoliticaPrivacidade from './PoliticaPrivacidade';

const { useToken } = theme;
const { useBreakpoint } = Grid;
const { Text, Title } = Typography;

const validateCPF = (cpf) => {
  cpf = cpf.replace(/[^\d]+/g, '');
  if (cpf === '') return false;
  if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) return false;
  let soma = 0, resto;
  for (let i = 1; i <= 9; i++) soma = soma + parseInt(cpf.substring(i-1, i)) * (11 - i);
  resto = (soma * 10) % 11;
  if ((resto === 10) || (resto === 11)) resto = 0;
  if (resto !== parseInt(cpf.substring(9, 10))) return false;
  soma = 0;
  for (let i = 1; i <= 10; i++) soma = soma + parseInt(cpf.substring(i-1, i)) * (12 - i);
  resto = (soma * 10) % 11;
  if ((resto === 10) || (resto === 11)) resto = 0;
  if (resto !== parseInt(cpf.substring(10, 11))) return false;
  return true;
}

function Cadastro() {
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [isPolicyAccepted, setIsPolicyAccepted] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const handleAcceptPolicy = (e) => {
    setIsPolicyAccepted(e.target.checked);
  };

  const { token } = useToken();
  const screens = useBreakpoint();

  const onFinish = (values) => {
    if (isPolicyAccepted) {
      console.log("Received values of form: ", values);
      // Handle form submission
    } else {
      showModal();
    }
  };

  const styles = {
    container: {
      margin: "0 auto",
      padding: screens.md ? `${token.paddingXL}px` : `${token.sizeXXL}px ${token.padding}px`,
      width: "480px"
    },
    footer: {
      marginTop: token.marginLG,
      textAlign: "center",
      width: "100%"
    },
    forgotPassword: {
      float: "right",
      color: "#730007"
    },
    header: {
      marginBottom: token.marginXL
    },
    section: {
      alignItems: "center",
      backgroundColor: token.colorBgContainer,
      display: "flex",
      height: screens.sm ? "100vh" : "auto",
      padding: screens.md ? `${token.sizeXXL}px 0px` : "0px"
    },
    text: {
      color: token.colorTextSecondary
    },
    title: {
      fontSize: screens.md ? token.fontSizeHeading2 : token.fontSizeHeading3
    }
  };

  return (
    <div className='mainWrapper' style={{ display: 'flex', flexDirection: 'row-reverse' }}>
      <div className='form' style={{ width: '50%' }}>
        <section style={styles.section}>
          <div style={styles.container}>
            <div style={styles.header}>
              <Title style={styles.title}>Cadastre-se</Title>
              <Text style={styles.text}>Bem-vindo ao RoomHub. Insira seus detalhes abaixo para efetuar o cadastro completo para inicar o uso de nosso projeto.</Text>
            </div>
            <Form
              name="normal_login"
              initialValues={{
                remember: true,
              }}
              onFinish={onFinish}
              layout="vertical"
              requiredMark="optional"
            >
              <Form.Item
                style={{ marginBottom: 20 }}
                name="email"
                rules={[
                  {
                    type: "email",
                    required: true,
                    message: "Por gentileza insira seu Email!",
                  },
                ]}
              >
                <Input
                  style={{ height: 40 }}
                  prefix={<MailOutlined />}
                  placeholder="Email"
                />
              </Form.Item>
              <Form.Item
                name="password"
                rules={[
                  {
                    required: true,
                    message: "Por gentileza insira sua senha!",
                  },
                ]}
              >
                <Input.Password
                  style={{ height: 40 }}
                  prefix={<LockOutlined />}
                  type="password"
                  placeholder="Senha"
                />
              </Form.Item>
              <Form.Item
                name="password2"
                rules={[
                  {
                    required: true,
                    message: "Por gentileza repita sua senha!",
                  },
                ]}
              >
                <Input.Password
                  style={{ height: 40 }}
                  prefix={<LockOutlined />}
                  type="password"
                  placeholder="Repita sua senha "
                />
              </Form.Item>
              <Form.Item
                style={{ marginBottom: 20 }}
                name="username"
                rules={[
                  {
                    type: "text",
                    required: true,
                    message: "Por gentileza insira seu nome de usuario!",
                  },
                ]}
              >
                <Input
                  style={{ height: 40 }}
                  prefix={<UserOutlined />}
                  placeholder="Nome de usuario"
                />
              </Form.Item>
              <Form.Item
                name="cpf"
                rules={[
                  {
                    required: true,
                    message: "Por gentileza insira seu CPF!",
                  },
                  {
                    validator: (_, value) =>
                      value && validateCPF(value)
                        ? Promise.resolve()
                        : Promise.reject(new Error('CPF inválido')),
                  },
                ]}
              >
                <Input
                  style={{ height: 40 }}
                  prefix={<PaperClipOutlined />}
                  type="text"
                  placeholder="CPF"
                  maxLength={11}
                />
              </Form.Item>
              <Form.Item name="nascimento" required>
                <Input
                  allowClear
                  placeholder='Data de nascimento'
                  style={{ height: 40 }}
                  type="date"
                />
              </Form.Item>
              <Form.Item style={{ marginBottom: "0px" }}>
                <Button block="true" style={{ backgroundColor: '#730007', color: 'white', border: 'none' }} htmlType="submit">
                  Finalizar Cadastro
                </Button>
              </Form.Item>
            </Form>
            <Modal
              title="Política de Privacidade"
              visible={isModalVisible}
              onOk={handleOk}
              onCancel={handleCancel}
              footer={[
                <div style={{display:'flex', justifyContent:'center', alignItems:'center', flexDirection:'column', marginTop: 25}}>
                  <Checkbox key="accept" onChange={handleAcceptPolicy}>
                  Eu aceito a política de privacidade
                  </Checkbox>
                  <Button style={{marginTop:10}} key="submit" type="primary" onClick={handleOk} disabled={!isPolicyAccepted}>
                  Concluir Cadastro
                  </Button>
                </div>
              ]}
            >
              <PoliticaPrivacidade />
            </Modal>
          </div>
        </section>
      </div>
      <div className='logo' style={{ backgroundColor: '#730007', width: '50%', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
        <img style={{ width: 300, margin: 0 }} src={logo}></img>
      </div>
    </div>
  );
}

export default Cadastro;
