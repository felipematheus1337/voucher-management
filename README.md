# Gift Voucher Service

Este repositório contém a implementação de um **sistema de criação e gerenciamento de vouchers de vale presente**. O projeto foi desenvolvido utilizando **Spring Boot** e diversas tecnologias modernas, visando garantir escalabilidade, segurança, e alta disponibilidade.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de microserviços.
- **Kafka**: Mensageria para comunicação entre serviços.
- **Redis**: Cache para melhorar a performance e reduzir latência.
- **JWT**: Autenticação e autorização com tokens.
- **Bucket4j** / **Spring Rate Limiter**: Implementação de limitação de taxa de requisições.
- **SLF4J & Logback**: Gerenciamento avançado de logs.
- **Prometheus & Grafana**: Monitoramento de métricas e performance.
- **Kubernetes**: Orquestração de containers.
- **Helm**: Ferramenta para gerenciamento de Kubernetes.

## Funcionalidades

- **Geração de vouchers**: Criação de vouchers de vale presente com valores customizáveis.
- **Autenticação e Autorização**: Proteção das APIs com JWT.
- **Mensageria com Kafka**: Comunicação entre microserviços via Kafka.
- **Cache com Redis**: Armazenamento temporário de dados para otimizar a performance.
- **Rate Limiting**: Limitação de requisições por usuário para proteger a API contra DoS.
- **Monitoramento**: Endpoints de saúde e métricas com Spring Boot Actuator, Prometheus e Grafana.
- **Escalabilidade**: Deploy no Kubernetes, com Helm para gerenciamento de versões e escalabilidade do sistema.

## Como Rodar o Projeto

### Requisitos

- **Java 21+**
- **Maven**
- **Docker** (opcional, para rodar Redis e Kafka localmente)
- **Kubernetes** (para deploy em ambiente de produção)

### Passos para execução local

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/gift-voucher-service.git
   cd gift-voucher-service
